package com.example.repository;

import com.example.entity.ManagementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagementRepository extends JpaRepository<ManagementEntity, Long> {
    List<ManagementEntity> findByBuildingEntityId(Long buildingid);
    Page<ManagementEntity> findByUserEntityId(Long buildingid, Pageable pageable);
    List<ManagementEntity> findByUserEntityId(Long userid);
    ManagementEntity findOneByUserEntityIdAndBuildingEntityId(Long userId, Long buildingId);
    Page<ManagementEntity> findByUserEntityIdAndIsPriority(Long userid, boolean priority, Pageable pageable);
    List<ManagementEntity> findByUserEntityIdAndIsPriority(Long userid, boolean priority);
}
