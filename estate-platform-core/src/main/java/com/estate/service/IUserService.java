package com.estate.service;

import com.estate.dto.BuildingDTO;
import com.estate.dto.UserDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserDTO> getUsers();
    Long getId(String name);
}
