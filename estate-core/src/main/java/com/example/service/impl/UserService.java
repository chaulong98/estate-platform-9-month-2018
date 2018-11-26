package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> findAllStaff() {
        List<UserEntity> userEntities = userRepository.findAllStaff();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity entity : userEntities){
            UserDTO dto = userConverter.convertToDto(entity);
            userDTOS.add(dto);
        }
        return userDTOS;
    }
}
