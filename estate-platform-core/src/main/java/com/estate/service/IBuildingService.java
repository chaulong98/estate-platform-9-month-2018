package com.estate.service;

import com.estate.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingDTO model, com.estate.repository.paging.Pageable pageable);
    void findAll(BuildingDTO model, Pageable pageable);
    BuildingDTO save(BuildingDTO buildingDTO);
    BuildingDTO update(BuildingDTO updateBuilding);
    BuildingDTO findById(long id);
    void assignStaff(long[] userID, long buildingId);
    List<Long> getStaffBuilding(long buildingId);
    void updatePriority(long buildingId, String action);
    List<BuildingDTO> findPriorityBuildings(BuildingDTO dto,Pageable pageable);
}
