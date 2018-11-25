package com.estate.repository;

import com.estate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String name);
    List<UserEntity> findAllByRoles_Code(String code);
    UserEntity findOneById(long id);
}
