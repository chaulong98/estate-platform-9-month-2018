package com.estate.service;

import com.estate.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IUserService {
    void findAllStaff(UserDTO model, Pageable pageable);

    Map<Long, String> getStaff();
}
