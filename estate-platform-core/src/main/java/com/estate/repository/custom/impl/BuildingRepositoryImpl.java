package com.estate.repository.custom.impl;

import com.estate.entity.BuildingEntity;
import com.estate.repository.custom.BuildingRepositoryCustom;
import com.estate.repository.paging.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    //muốn sử dụng query thì cần entityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(Pageable pageable) {

        StringBuilder sql = new StringBuilder(" FROM BuildingEntity ");
        Query query = entityManager.createQuery(sql.toString());
        if (pageable.getOffset() != null){
            query.setFirstResult(pageable.getOffset());
        }
        if (pageable.getPageSize() != null){
            query.setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public Long getTotalItems() {
        StringBuilder sql = new StringBuilder("select count(*) from BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }

}
