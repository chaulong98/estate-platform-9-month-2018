package com.estate.service;

import com.estate.dto.BuildingDTO;
//import org.springframework.data.domain.Pageable;
import com.estate.repository.paging.PageRequest;
import com.estate.repository.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingDTO model, com.estate.repository.paging.PageRequest pageRequest);
    BuildingDTO save(BuildingDTO newDTO);
    BuildingDTO update(BuildingDTO updateNew);
    BuildingDTO findById(long id);
    Map<String, String> getBuildingTypes();
    Long[] findUserAssignments (Long id);
    void deleteBuilding(long[] id);
}
