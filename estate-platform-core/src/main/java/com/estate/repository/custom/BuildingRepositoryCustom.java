package com.estate.repository.custom;

import com.estate.entity.BuildingEntity;
import com.estate.repository.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {
    /*JPA custom*/
    List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable);
    Long getTotalItems(Map<String, Object> properties);
}
