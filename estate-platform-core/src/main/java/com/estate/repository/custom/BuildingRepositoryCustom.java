package com.estate.repository.custom;

import com.estate.entity.BuildingEntity;
import com.estate.paging.PageRequest;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(PageRequest pageRequest);
    Long getTotalItems();
}
