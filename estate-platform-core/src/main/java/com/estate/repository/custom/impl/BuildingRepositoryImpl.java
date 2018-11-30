package com.estate.repository.custom.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.paging.PageRequest;
import com.estate.repository.custom.BuildingRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    //muốn sử dụng query thì cần entityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingBuilder builder, PageRequest pageRequest) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building AS b");
        sql.append(" WHERE 1 = 1 ");
        return null;
    }

    @Override
    public Long getTotalItems() {
        StringBuilder sql = new StringBuilder("select count(*) from BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }

}
