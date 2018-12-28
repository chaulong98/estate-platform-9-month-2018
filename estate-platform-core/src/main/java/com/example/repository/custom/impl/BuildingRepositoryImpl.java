package com.example.repository.custom.impl;

import com.example.builder.BuildingBuilder;
import com.example.entity.BuildingEntity;
import com.example.paging.PageRequest;
import com.example.paging.Pageable;
import com.example.repository.custom.BuildingRepositoryCustom;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingBuilder buildingBuilder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building AS b");
        if(buildingBuilder.getStaffId() != null){
            sql.append(" INNER JOIN management AS ma ON ma.buildingid = b.id");
        }
        sql.append(" WHERE 1=1 ");
       /* if(buildingBuilder.getBuildingName() != null){
            sql.append(" AND LOWER(b.buildingname) LIKE '%"+buildingBuilder.getBuildingName().toLowerCase()+"%' ");
        }
        if(buildingBuilder.getDistrict() != null){
            sql.append(" AND LOWER(b.district) LIKE '%"+buildingBuilder.getDistrict().toLowerCase()+"%' ");
        }
        if(buildingBuilder.getBasementArea() != null){
            sql.append(" AND b.basementarea = "+buildingBuilder.getBasementArea()+" ");
        }
        if(buildingBuilder.getBasementNumber() != null){
            sql.append(" AND b.basementnumber = "+buildingBuilder.getBasementNumber()+" ");
        }*/
       sql = buildQueryBuilding(sql, buildingBuilder);
       if(buildingBuilder.getStaffId() != null){
           sql.append(" AND ma.userid = "+buildingBuilder.getStaffId()+" ");
       }
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildQueryBuilding(StringBuilder sql, BuildingBuilder buildingBuilder) {
        Field[] fields = BuildingBuilder.class.getDeclaredFields();
        for(Field field : fields){
            //Loại các case tìm kiếm đặc biệt
            if(field.getName().equals("staffName") || field.getName().equals("productType") || field.getName().startsWith("area") ||
            field.getName().startsWith("cost")){
                continue;
            }
            String fieldType = field.getType().getName();
            if(fieldType.equals("java.lang.String")){
                String value = getValue(field, String.class, buildingBuilder);
                if(StringUtils.isNotBlank(value)){
                    sql.append(" AND LOWER(b."+field.getName().toLowerCase()+") LIKE '%"+value.toLowerCase()+"%' ");
                }
            }else if(fieldType.equals("java.lang.Integer")){
                Integer value = getValue(field, Integer.class, buildingBuilder);
                if(value != null){
                    sql.append(" AND b."+field.getName()+" = "+value+" ");
                }
            }
        }
        if(buildingBuilder.getCostFrom() != null){
            sql.append(" AND b.releasedcost >= "+buildingBuilder.getCostFrom()+" ");
        }
        if(buildingBuilder.getCostTo() != null){
            sql.append(" AND b.releasedcost <= "+buildingBuilder.getCostTo()+" ");
        }
        if(buildingBuilder.getProductType().length > 0){
            sql.append(" AND (b.type LIKE '%"+buildingBuilder.getProductType()[0]+"%' ");
            int i = 0;
            for(String item : buildingBuilder.getProductType()){
                if(i != 0){
                    sql.append(" OR b.type LIKE '%"+buildingBuilder.getProductType()[i]+"%' ");
                }
                i++;
            }
           /* Arrays.stream(buildingBuilder.getProductType()).filter(item -> !item.equals(buildingBuilder.getProductType()[0]))
                    .forEach(item -> sql.append(" OR b.type LIKE '%"+item+"%' "));*/
            sql.append(")");
        }

        if (buildingBuilder.getAreaFrom() != null && buildingBuilder.getAreaTo() != null) {
            sql.append(" AND EXISTS(SELECT area FROM UNNEST(string_to_array(b.releasedarea, ',')) AS area ");
            sql.append(" WHERE CAST(area as int) BETWEEN "+buildingBuilder.getAreaFrom()+" AND "+buildingBuilder.getAreaTo()+") ");
        } else {
            if (buildingBuilder.getAreaFrom() != null && buildingBuilder.getAreaTo() == null) {
                sql.append(" AND EXISTS(SELECT area FROM UNNEST(string_to_array(b.releasedarea, ',')) AS area ");
                sql.append(" WHERE CAST(area as int) >= "+buildingBuilder.getAreaFrom()+") ");
            } else if (buildingBuilder.getAreaFrom() == null && buildingBuilder.getAreaTo() != null) {
                sql.append(" AND EXISTS(SELECT area FROM UNNEST(string_to_array(b.releasedarea, ',')) AS area ");
                sql.append(" WHERE CAST(area as int) <= "+buildingBuilder.getAreaTo()+") ");
            }
        }
        return sql;
    }

    //Class<String> a = class java.lang.String
    //Class<Integer> b = class java.lang.Integer
    private <T> T getValue(Field field, Class<T> type, BuildingBuilder buildingBuilder) {
        Object result = null;
        Method getter = getGetter(field, buildingBuilder);
        if(getter != null){
            try {
                result = getter.invoke(buildingBuilder);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return type.cast(result);
    }

    private Method getGetter(Field field, BuildingBuilder buildingBuilder) {
        String getterMethodName = "get" + StringUtils.capitalize(field.getName());
        try {
            return buildingBuilder.getClass().getMethod(getterMethodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
