package com.example.repository;


import com.example.entity.UserEntity;
import com.example.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    UserEntity findOneByUserName(String name);
}
