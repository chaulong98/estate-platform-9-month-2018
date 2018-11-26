package com.estate.repository;

import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    Page<BuildingEntity> findAll(Pageable pageable);

    //tim building theo users
    List<BuildingEntity> findAllByUsers(UserEntity userEntity);
}