package com.example.service;

import com.example.dto.BuildingDTO;
import com.example.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);
    BuildingDTO findById(Long id);
    BuildingDTO save(BuildingDTO dto);
    BuildingDTO update(BuildingDTO dto);
    List<UserDTO> getStaff(String roleCode, Long buildingId);
    BuildingDTO assignBuilding(long[] staffIds, Long buildingId);
    Integer addPriorityBuilding(Long buildingId);
    Integer deletePriorityBuilding(Long buildingId);
    void findPriorityBuilding(BuildingDTO model, Pageable pageable);
}
