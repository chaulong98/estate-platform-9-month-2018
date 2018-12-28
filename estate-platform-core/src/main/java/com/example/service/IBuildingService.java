package com.example.service;

import com.example.dto.BuildingDTO;
import com.example.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingDTO model, com.example.paging.Pageable pageable);
    void findAssinedBuilding(BuildingDTO model,Long userid, Pageable pageable);
    BuildingDTO findById(Long id);
    BuildingDTO save(BuildingDTO dto);
    BuildingDTO update(BuildingDTO dto);
    List<UserDTO> getStaff(String roleCode, Long buildingId);
    BuildingDTO assignBuilding(long[] staffIds, Long buildingId);
    void addPriorityBuilding(Long buildingId);
    void deletePriorityBuilding(Long buildingId);
    void findPriorityBuilding(BuildingDTO model, Pageable pageable);
}
