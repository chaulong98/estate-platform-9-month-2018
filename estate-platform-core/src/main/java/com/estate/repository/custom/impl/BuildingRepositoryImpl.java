package com.estate.repository.custom.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.repository.custom.BuildingRepositoryCustom;
import com.estate.repository.paging.PageRequest;
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
    public List<BuildingEntity> findAll(BuildingBuilder builder, PageRequest pageRequest) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building AS b");
        sql.append(" WHERE 1 = 1 ");
        return null;
    }




    @Override
    public Long getTotalItems(Map<String, Object> properties) {
        /*SQL native*/
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM building AS n");

        sql.append(" WHERE 1=1 ");

        Query query = entityManager.createNativeQuery(sql.toString());

        List<BigInteger> bigIntegers = query.getResultList();
        return Long.parseLong(bigIntegers.get(0).toString(), 10);

    }
}
