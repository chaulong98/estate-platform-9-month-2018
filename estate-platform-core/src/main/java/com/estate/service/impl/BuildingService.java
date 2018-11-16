package com.estate.service.impl;

import com.estate.constant.BuildingType;
import com.estate.converter.BuildingConverter;
import com.estate.dto.BuildingDTO;
import com.estate.entity.BuildingEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.DistrictRepository;
import com.estate.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> builds = buildingRepository.findAll(pageable).getContent();
        model.setListResult(builds.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItem(buildingRepository.getTotalItems().intValue());
    }

    @Override
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingEntity.setType(String.join(",", buildingDTO.getTypeBuilding()));
        buildingEntity = buildingRepository.save(buildingEntity);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    public BuildingDTO update(BuildingDTO updateDTO) {
        BuildingEntity exitBuilding = new BuildingEntity();
        exitBuilding = buildingRepository.findOne(updateDTO.getId());
        BuildingEntity updateBuilding = buildingConverter.convertToEntity(updateDTO);
        updateBuilding.setCreatedBy(exitBuilding.getCreatedBy());
        updateBuilding.setCreatedDate(exitBuilding.getCreatedDate());
        updateBuilding.setType(String.join(",", updateDTO.getTypeBuilding()));
        exitBuilding = buildingRepository.save(updateBuilding);
        return buildingConverter.convertToDto(exitBuilding);
    }

    @Override
    public BuildingDTO findOneId(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        BuildingDTO dto = new BuildingDTO();
        dto = buildingConverter.convertToDto(buildingEntity);
        //String[] types = new String[]{};
        dto.setTypeBuilding(buildingEntity.getType().split(","));
        return dto;
    }

    @Override
    public Map<String, String> getBuildingType() {
        Map<String, String> results = new HashMap<>();
        for (BuildingType item : BuildingType.values()) {
            results.put(item.name(), item.getName());
        }
        return results;
    }
}
