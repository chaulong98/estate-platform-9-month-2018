package com.estate.service;

import com.estate.dto.UserDTO;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    void findAll(UserDTO model, Pageable pageable);
}
