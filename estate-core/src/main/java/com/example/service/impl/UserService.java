package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.UserDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.repository.custom.UserRepositoryCustom;
import com.example.repository.custom.impl.UserRepositoryImpl;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    /*private UserRepositoryCustom userRepositoryCustom = new UserRepositoryImpl();*/

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findbyRoleCode(String code) {
        RoleEntity roleEntity = roleRepository.findOneByCode(code);
        List<UserEntity> userEntities = roleEntity.getUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity entity : userEntities){
            UserDTO dto = userConverter.convertToDto(entity);
            userDTOS.add(dto);
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> findByListId(String[] listId) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for(String id : listId){
            UserEntity entity = userRepository.findOne(Long.parseLong(id));
            UserDTO dto = userConverter.convertToDto(entity);
            userDTOS.add(dto);
        }
        return userDTOS;
    }
}
