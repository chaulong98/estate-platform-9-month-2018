package com.estate.service.impl;

import com.estate.constant.SystemConstant;
import com.estate.converter.UserConverter;
import com.estate.dto.UserDTO;
import com.estate.entity.UserEntity;
import com.estate.repository.UserRepository;
import com.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

    public void findAll(UserDTO model, Pageable pageable) {
        List<UserEntity> userList = userRepository.findAllByRoles_Code("USER");
        model.setListResult(userList.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList()));
    }
}
