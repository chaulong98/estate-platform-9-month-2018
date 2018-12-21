package com.estate.repository.custom;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.paging.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingBuilder builder, Pageable pageable);
    Long getTotalItems();
    Long getTotalItems(BuildingBuilder builder);
}
