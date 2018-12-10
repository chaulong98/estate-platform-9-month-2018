package com.example.service;

import com.example.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findbyRoleCode(String code);
    List<UserDTO> findByListId(long[] listId);
}
