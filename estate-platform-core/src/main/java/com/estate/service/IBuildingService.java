package com.estate.service;

import com.estate.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);
    BuildingDTO save(BuildingDTO buildingDTO);
    BuildingDTO update(BuildingDTO updateBuilding);
    BuildingDTO findById(long id);
    void assignStaff(long[] userID, long buildingId);

    List<Long> getStaffBuilding(long buildingId);
}
