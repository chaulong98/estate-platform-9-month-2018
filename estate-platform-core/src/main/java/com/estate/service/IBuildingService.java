package com.estate.service;

import com.estate.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingDTO model, com.estate.paging.Pageable pageRequest);
    int getTotalItems(BuildingDTO model);
    void findBuildingPriority(BuildingDTO model, Pageable pageable);
    BuildingDTO save(BuildingDTO buildingDTO);
    BuildingDTO update(BuildingDTO buildingDTO);
    BuildingDTO findOneId(Long id);
    Map<String, String> getBuildingType();
    void deleteBuilding(long[] id);
    void deleteBuildingPriority(long[] id);

    void assignStaffsToBuilding(Long buildingId, long[] userIds);

    void findBuildingByUsers(BuildingDTO model, Pageable pageable);

    void buildingPriority(Long buildingId);

}
