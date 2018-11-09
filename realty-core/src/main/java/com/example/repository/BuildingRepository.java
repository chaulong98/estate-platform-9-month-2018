package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BuildingEntity;
import com.example.entity.UserEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
//	Page<BuildingEntity> findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(String userName,String fullName, Pageable pageable);
	BuildingEntity findOneById(Long id);

}
