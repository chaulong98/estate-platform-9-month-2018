package com.estate.repository.custom.impl;

import com.estate.repository.custom.BuildingRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    //muốn sử dụng query thì cần entityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long getTotalItems() {
        StringBuilder sql = new StringBuilder("select count(*) from BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }

}
