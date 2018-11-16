package com.estate.repository;

import com.estate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String name);
    List<UserEntity> findByRoles_Code(String code);
    //tim id theo fullName
    Long findIdByFullName(String name);
}
