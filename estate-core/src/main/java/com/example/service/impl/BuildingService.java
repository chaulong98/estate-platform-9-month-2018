package com.example.service.impl;

import com.example.converter.BuildingConverter;
import com.example.dto.BuildingDTO;
import com.example.entity.BuildingEntity;
import com.example.repository.BuildingRepository;
import com.example.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService implements IBuildingService{

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    BuildingConverter buildingConverter;

    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(pageable).getContent();
        List<BuildingDTO> buildingDTOS = new ArrayList<>();
        for(BuildingEntity entity : buildingEntities){
            BuildingDTO dto = buildingConverter.convertToDto(entity);
            buildingDTOS.add(dto);
        }
        model.setListResult(buildingDTOS);
        model.setTotalPages((int) ((buildingRepository.count())/(model.getMaxPageItems())));
    }
}
