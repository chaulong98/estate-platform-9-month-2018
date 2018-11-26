package com.example.repository.custom;

import com.example.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserEntity> findAllStaff();
}
