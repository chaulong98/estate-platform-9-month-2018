package com.example.repository;

import com.example.entity.ManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagementRepository extends JpaRepository<ManagementEntity, Long> {
    List<ManagementEntity> findByBuildingEntityId(Long buildingid);
    List<ManagementEntity> findByUserEntityId(Long userid);
    ManagementEntity findOneByUserEntityIdAndBuildingEntityId(Long userId, Long buildingId);
}
