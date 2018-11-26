package com.example.service.impl;

import com.example.converter.BuildingConverter;
import com.example.dto.BuildingDTO;
import com.example.entity.BuildingEntity;
import com.example.repository.BuildingRepository;
import com.example.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public BuildingDTO findById(Long id){
        BuildingEntity entity = buildingRepository.findOne(id);
        BuildingDTO dto = buildingConverter.convertToDto(entity);
        return dto;
    }

    @Override
    public BuildingDTO save(BuildingDTO dto) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(dto);
        buildingEntity = buildingRepository.save(buildingEntity);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    public BuildingDTO update(BuildingDTO updateDto) {
        BuildingEntity updateEntity = buildingConverter.convertToEntity(updateDto);
        BuildingEntity existEntity = buildingRepository.findOne(updateDto.getId());
        updateEntity.setStaffs(existEntity.getStaffs());
        existEntity = buildingRepository.save(updateEntity);
        return buildingConverter.convertToDto(existEntity);
    }
}
