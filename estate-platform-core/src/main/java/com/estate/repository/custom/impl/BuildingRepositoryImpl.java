package com.estate.repository.custom.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.paging.PageRequest;
import com.estate.paging.Pageable;
import com.estate.repository.custom.BuildingRepositoryCustom;
import org.apache.commons.lang.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    //muốn sử dụng query thì cần entityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM estateletuan.building AS b");
        sql.append(" WHERE 1 = 1 ");
        sql = buildQueryBuilding(sql, builder);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildQueryBuilding(StringBuilder sql, BuildingBuilder builder) {
        Field[] fields = BuildingBuilder.class.getDeclaredFields();
        for (Field field: fields) {
            if (!field.getName().equals("staffName") && !field.getName().equals("typeBuilding")
                    && !field.getName().startsWith("area") && !field.getName().startsWith("cost")) {
                String fieldType = field.getType().getName();
                if (fieldType.equals("java.lang.String")) {
                    String value = getValue(field, String.class, builder);
                    sql.append(" AND LOWER(b."+field.getName().toLowerCase()+") LIKE '%"+value.toLowerCase()+"%' ");
                } else if (fieldType.equals("java.lang.Integer")) {
                    Integer value = getValue(field, Integer.class, builder);
                    sql.append(" AND b."+field.getName().toLowerCase()+" = "+value+" ");
                }
            }
        }
        if (builder.getCostFrom() != null) {
            sql.append(" AND b.rentcost >= "+builder.getCostFrom()+" ");
        }
        if (builder.getCostTo() != null) {
            sql.append(" AND b.rentcost <= "+builder.getCostTo()+" ");
        }
        if (builder.getTypeBuilding().length > 0) {

        }
        return sql;
    }

    private <T> T getValue(Field field, Class<T> type, BuildingBuilder builder) {
        Object result = null;
        Method getter = getGetter(field, builder);
        if (getter != null) {
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

    @Override
    public Long getTotalItems() {
        StringBuilder sql = new StringBuilder("select count(*) from BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }

}
