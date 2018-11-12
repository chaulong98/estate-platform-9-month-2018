package com.estate.repository;

import com.estate.entity.BuildingEntity;
import com.estate.page.Pageable;
import com.estate.repository.custom.CustomBuildingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, CustomBuildingRepository {
	Page<BuildingEntity> findByUsers_Id(Long id, Pageable pageable);
	long countByUsers_Id(Long id);
}
