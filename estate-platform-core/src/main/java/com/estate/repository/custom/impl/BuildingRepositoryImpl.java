package com.estate.repository.custom.impl;

import com.estate.entity.BuildingEntity;
import com.estate.repository.custom.BuildingRepositoryCustom;
import com.estate.repository.paging.Pageable;
import com.estate.utils.QueryUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable) {
        /*SQL native*/
//        StringBuilder sql = new StringBuilder("SELECT * FROM building AS n ");
//
//        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
//
//        if (pageable.getOffset() != null) {
//            query.setFirstResult(pageable.getOffset());
//        }
//        if (pageable.getPageSize() != null) {
//            query.setMaxResults(pageable.getPageSize());
//        }
        /*HQL*/
        Object[] objects = QueryUtils.buildQuery(properties);
        StringBuilder sql = new StringBuilder("FROM BuildingEntity WHERE 1=1 ").append(objects[0]);
        Query query = entityManager.createQuery(sql.toString());
        initValueOfParameterToQuery(objects, query);
        if (pageable.getOffset() != null) {
            query.setFirstResult(pageable.getOffset());
        }
        if (pageable.getPageSize() != null) {
            query.setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    private void initValueOfParameterToQuery(Object[] objects, Query query) {
        if (objects.length == 3) {
            String[] keys = (String[]) objects[1];
            Object[] values = (Object[]) objects[2];
            for (int i = 0; i < keys.length; i++) {
                query.setParameter(keys[i], values[i]);
            }
        }
    }

    /*@Override*/
    /*SQL native*/
    public Long getTotalItems(Map<String, Object> properties) {
        /*SQL native*/
//        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM building AS n");
//
//        sql.append(" WHERE 1=1 ");
//
//        Query query = entityManager.createNativeQuery(sql.toString());
//
//        List<BigInteger> bigIntegers = query.getResultList();
//        return Long.parseLong(bigIntegers.get(0).toString(), 10);
        /*HQL*/
        Object[] objects = QueryUtils.buildQuery(properties);
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM BuildingEntity WHERE 1=1").append(objects[0]);
        Query query = entityManager.createQuery(sql.toString());
        initValueOfParameterToQuery(objects, query);
        return (Long) query.getResultList().get(0);
    }
}
