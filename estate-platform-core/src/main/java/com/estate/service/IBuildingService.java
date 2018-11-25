package com.estate.service;

import com.estate.dto.BuildingDTO;
//import org.springframework.data.domain.Pageable;
import com.estate.repository.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    void findAll(BuildingDTO model, Pageable pageable);
    BuildingDTO save(BuildingDTO newDTO);
    BuildingDTO update(BuildingDTO updateNew);
    BuildingDTO findById(long id);
    Map<String, String> getBuildingTypes();
    Long[] findUserAssignments (Long id);
}
