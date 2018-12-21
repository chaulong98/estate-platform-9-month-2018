package com.estate.repository.custom.impl;

import com.estate.repository.custom.CustomBuildingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CustomBuildingRepositoryImpl implements CustomBuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long getTotalItems() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM BuildingEntity");
        return (Long) query.getResultList().get(0);
    }
}
