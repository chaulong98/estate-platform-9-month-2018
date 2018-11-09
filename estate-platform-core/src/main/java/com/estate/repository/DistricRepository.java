package com.estate.repository;

import com.estate.entity.DistricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistricRepository extends JpaRepository<DistricEntity, Long> {
    DistricEntity findOneByCode(String code);
}
