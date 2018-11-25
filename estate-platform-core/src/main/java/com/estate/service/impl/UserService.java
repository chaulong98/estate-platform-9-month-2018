package com.estate.service.impl;

import com.estate.converter.UserConverter;
import com.estate.dto.UserDTO;
import com.estate.entity.UserEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.UserRepository;
import com.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;


    @Override
    public List<UserDTO> findStaffs() {
        List<UserEntity> staffEntities = userRepository.findByStatusAndRoles_Code(1,"USER");
        return staffEntities.stream().map(item ->userConverter.convertToDto(item)).collect(Collectors.toList());
    }
}
