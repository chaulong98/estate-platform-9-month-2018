package com.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estate.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code);
}
