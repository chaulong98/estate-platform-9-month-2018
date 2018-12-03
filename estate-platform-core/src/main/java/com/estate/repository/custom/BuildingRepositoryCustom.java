package com.estate.repository.custom;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.repository.paging.PageRequest;
import com.estate.repository.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {
    /*JPA custom*/
    List<BuildingEntity> findAll(BuildingBuilder builder, PageRequest pageRequest);
    Long getTotalItems(Map<String, Object> properties);
}
