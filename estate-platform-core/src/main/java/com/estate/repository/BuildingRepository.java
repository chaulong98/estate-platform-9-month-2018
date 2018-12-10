package com.estate.repository;

import com.estate.entity.BuildingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
    Page<BuildingEntity> findAll(Pageable pageable);
    BuildingEntity findOneById(long id);
}
