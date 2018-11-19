package com.example.service;

import com.example.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;

public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);
}
