package com.example.repository.custom.impl;

import com.example.entity.UserEntity;
import com.example.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findAllStaff() {
        StringBuilder sql = new StringBuilder("FROM UserEntity");
        sql.append("WHERE roles.code = 'MANAGER'");
        Query query = entityManager.createQuery(sql.toString());
        return query.getResultList();
    }
}
