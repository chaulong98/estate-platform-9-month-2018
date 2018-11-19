package com.estate.service.impl;

import com.estate.converter.BuildingConverter;
import com.estate.converter.UserConverter;
import com.estate.dto.BuildingDTO;
import com.estate.dto.UserDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.repository.UserRepository;
import com.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> results = new ArrayList<>();
        results = userRepository.findByRoles_CodeAndStatus("USER", "1").stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
        return results;
    }

    @Override
    public Long getId(String name) {
        Long id = userRepository.findIdByFullName("a");
        return null;
    }
}
