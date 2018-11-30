package com.estate.repository.custom;

import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.paging.PageRequest;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingBuilder builder, PageRequest pageRequest);
    Long getTotalItems();
}
