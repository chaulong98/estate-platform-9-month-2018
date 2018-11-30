package com.estate.service.impl;

import com.estate.converter.UserConverter;
import com.estate.dto.UserDTO;
import com.estate.repository.UserRepository;
import com.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> getUsers(Long buildingId) {
        List<UserDTO> results = new ArrayList<>();
        results = userRepository.findByRoles_CodeAndStatus("USER", "1").stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());

        //tim user theo building id
//        List<UserDTO> userDTOS = userRepository.findByBuildings_Id(buildingId).stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
//        for (UserDTO item : userDTOS) {
//            for (UserDTO item1 : results){
//                if (item1.getUserName().equals(item.getUserName())){
//                    item1.setCheck("checked");
//                }
//            }
//        }
        return results;
    }

    @Override
    public Map<String, String> getStaffs() {
        List<UserDTO> userDTOS = new ArrayList<>();
        Map<String, String> results = new HashMap<>();
        userDTOS = userRepository.findByRoles_CodeAndStatus("USER", "1").stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
        for (UserDTO item : userDTOS){
            results.put(item.getUserName(), item.getFullName());
        }
        return results;
    }
}
