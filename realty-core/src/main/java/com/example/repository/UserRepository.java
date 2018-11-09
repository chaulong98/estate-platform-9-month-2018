package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUserName(String name);
	UserEntity findOneByEmail(String email);
	Page<UserEntity> findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(String userName,String fullName, Pageable pageable);
	long countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(String userName,String fullName);
}
