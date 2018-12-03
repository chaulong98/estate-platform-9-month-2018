package com.estate.repository.custom.impl;

import com.estate.entity.CustomerEntity;
import com.estate.repository.custom.CustomerRepositoryCustom;
import com.estate.repository.paging.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;



    @Repository
    public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public List<CustomerEntity> findAll(Map<String, Object> properties, Pageable pageable) {
            /*SQL native*/
        StringBuilder sql = new StringBuilder("SELECT * FROM customers AS n ");

        sql.append(" WHERE 1=1 ");

        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);

        if (pageable.getOffset() != null) {
            query.setFirstResult(pageable.getOffset());
        }
        if (pageable.getPageSize() != null) {
            query.setMaxResults(pageable.getPageSize());
        }

            return query.getResultList();
        }




        /*@Override*/
        /*SQL native*/
        public Long getTotalItems(Map<String, Object> properties) {
            /*SQL native*/
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM customers AS n");

        sql.append(" WHERE 1=1 ");

        Query query = entityManager.createNativeQuery(sql.toString());

        List<BigInteger> bigIntegers = query.getResultList();
        return Long.parseLong(bigIntegers.get(0).toString(), 10);




        }

        @Override
        public String getPermission(String userName, String pass) {

            return null;
        }
    }


