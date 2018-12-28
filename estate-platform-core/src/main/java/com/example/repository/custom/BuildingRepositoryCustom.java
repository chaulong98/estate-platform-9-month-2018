package com.example.repository.custom;

import com.example.builder.BuildingBuilder;
import com.example.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingBuilder buildingBuilder, com.example.paging.Pageable pageable);
}
