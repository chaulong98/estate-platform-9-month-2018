package com.estate.repository.custom;


import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.page.PageRequest;
import com.estate.page.Pageable;

import java.util.List;

public interface CustomBuildingRepository {
	List<BuildingEntity> findAll(BuildingBuilder buildingBuilder, PageRequest pageRequest);
	Long getTotalItems(BuildingBuilder builder);
}
