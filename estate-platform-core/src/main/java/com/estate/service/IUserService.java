package com.estate.service;

import com.estate.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<UserDTO> getUsers(Long buildingId);
    Map<String, String> getStaffs();
}
