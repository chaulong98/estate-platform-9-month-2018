package com.example.service;

import com.example.dto.UserDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IUserService {
    List<UserDTO> findAllActiveStaff();
}
