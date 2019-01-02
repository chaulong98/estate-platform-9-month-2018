package com.estate.repository.custom.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.repository.custom.CustomBuildingRepository;
import com.estate.repository.paging.PageRequest;
import com.estate.repository.paging.Pageable;
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
public class CustomBuildingRepositoryImpl implements CustomBuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long getTotalItems() {
        Query query = entityManager.createQuery("SELECT COUNT (*) FROM BuildingEntity");
        return (Long) query.getResultList().get(0);
    }

    @Override
    public List<BuildingEntity> findAll(BuildingBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM estatetrunganh.building AS b");
        if (builder.getStaffId() != null){
            sql.append(" INNER JOIN estatetrunganh.staff_building AS sb ON sb.building_id = b.id ");
        }
        sql.append(" WHERE 1 = 1 ");
        sql = BuildQueryBuilding(sql, builder);
        if (builder.getStaffId() != null){
            sql.append(" AND sb.user_id = "+builder.getStaffId()+" ");
        }
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder BuildQueryBuilding(StringBuilder sql, BuildingBuilder builder) {
        Field[] fields = BuildingBuilder.class.getDeclaredFields();
        for (Field field: fields) {
            if (!field.getName().equals("staffName") && !field.getName().equals("type")
                    && !field.getName().startsWith("area") && !field.getName().startsWith("cost")) {
                String fieldType = field.getType().getName();
                if (fieldType.equals("java.lang.String")) {
                    String value = getValue(field, String.class, builder);
                    if (StringUtils.isNotBlank(value)) {
                        sql.append(" AND LOWER(b."+field.getName().toLowerCase()+") LIKE '%"+value.toLowerCase()+"%' ");
                    }
                } else if (fieldType.equals("java.lang.Integer")) {
                    Integer value = getValue(field, Integer.class, builder);
                    if (value != null) {
                        sql.append(" AND b."+field.getName().toLowerCase()+" = "+value+" ");
                    }
                }
            }
        }
        if (builder.getCostFrom() != null) {
            sql.append(" AND b.rentfee >= "+builder.getCostFrom()+" ");
        }
        if (builder.getCostTo() != null) {
            sql.append(" AND b.rentfee <= "+builder.getCostTo()+" ");
        }
        if (StringUtils.isNotBlank(builder.getType())) {
            sql.append(" AND (b.type LIKE '%"+builder.getType().split(",")[0]+"%'");
            Arrays.stream(builder.getType().split(",")).filter(item -> !item.equals(builder.getType().split(",")[0])).forEach(item -> sql.append(" OR b.type LIKE '%"+item+"%'"));
            sql.append(")");
        }
        if (builder.getAreaFrom() != null && builder.getAreaTo() != null) {
            sql.append(" AND EXISTS(SELECT area FROM UNNEST(string_to_array(b.rentarea, ',')) AS area ");
            sql.append(" WHERE CAST(area as int) BETWEEN "+builder.getAreaFrom()+" AND "+builder.getAreaTo()+") ");
        } else {
            if (builder.getAreaFrom() != null && builder.getAreaTo() == null) {
                sql.append(" AND EXISTS(SELECT area FROM UNNEST(string_to_array(b.rentarea, ',')) AS area ");
                sql.append(" WHERE CAST(area as int) >= "+builder.getAreaFrom()+") ");
            } else if (builder.getAreaFrom() == null && builder.getAreaTo() != null) {
                sql.append(" AND EXISTS(SELECT area FROM UNNEST(string_to_array(b.rentarea, ',')) AS area ");
                sql.append(" WHERE CAST(area as int) <= "+builder.getAreaTo()+") ");
            }
        }
        return sql;
    }

    private <T> T getValue(Field field, Class<T> type, BuildingBuilder builder) {
        Object result = null;
        Method getter = getGetter(field,builder);
        if(getter !=null){
            try {
                result = getter.invoke(builder);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return type.cast(result);
    }

    private Method getGetter(Field field, BuildingBuilder builder) {
        String getterMethodName = "get" + StringUtils.capitalize(field.getName());
        try {
            return builder.getClass().getMethod(getterMethodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }

    }
}
