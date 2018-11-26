package com.estate.service;

import com.estate.dto.BuildingDTO;
import com.estate.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);

    BuildingDTO save(BuildingDTO buildingDTO);

    BuildingDTO update(BuildingDTO buildingDTO);

    BuildingDTO findOneId(Long id);

    Map<String, String> getBuildingType();

    void deleteBuilding(long[] id);

    void staffsBuilding(Long buildingId, long[] userIds);

    void findBuildingByUsers(BuildingDTO model);
}
