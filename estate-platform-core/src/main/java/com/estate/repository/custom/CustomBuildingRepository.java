package com.estate.repository.custom;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.repository.paging.PageRequest;
import com.estate.repository.paging.Pageable;

import java.util.List;

public interface CustomBuildingRepository {
    Long getTotalItems();
    List<BuildingEntity> findAll(BuildingBuilder builder, Pageable pageable);
}
