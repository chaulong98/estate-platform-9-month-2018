package com.estate.repository.custom;

import com.estate.entity.BuildingEntity;
import com.estate.repository.paging.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(Pageable pageable);
    Long getTotalItems();
}
