package com.estate.service;

import com.estate.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;


public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);
    BuildingDTO save(BuildingDTO newDTO);
    BuildingDTO update(BuildingDTO updateNew);
    BuildingDTO findById(long id);
}
