package com.estate.service.impl;

import com.estate.constant.SystemConstant;
import com.estate.converter.BuildingConverter;

import com.estate.dto.BuildingDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.DistrictEntity;
import com.estate.enums.BuildingType;
import com.estate.repository.BuildingRepository;
import com.estate.repository.DistrictRepository;
import com.estate.service.IBuildingService;
import com.estate.utils.UploadFileUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
import com.estate.repository.paging.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BuildingService implements IBuildingService {


    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        /*Custom JPA*/
        Map<String, Object> properties = buildBuildingProperties(model);
        List<BuildingEntity> builds = buildingRepository.findAll(properties, pageable);
        model.setListResult(builds.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItems(buildingRepository.getTotalItems(properties).intValue());
        /*spring data jpa*/
        /*model.setBuildingName(Optional.ofNullable(model.getBuildingName()).orElse(""));
        //model.setContent(Optional.ofNullable(model.getContent()).orElse(""));
       // model.setCategoryName(Optional.ofNullable(model.getCategoryName()).orElse(""));
        List<BuildingEntity> builds = buildingRepository.findByTitleContainingIgnoreCaseAndContentContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(model.getBuildingName(), pageable).getContent();
        model.setListResult(builds.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItems((int) buildingRepository.countByTitleContainingIgnoreCaseAndContentContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(model.getBuildingName());*/
    }



    private Map<String,Object> buildBuildingProperties(BuildingDTO model) {
        Map<String, Object> results = new HashMap<>();
        if (StringUtils.isNotBlank(model.getBuildingName())) {
            results.put("buildingName", model.getBuildingName());
        }


        return results;
    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {

        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingEntity.setType(String.join(",", buildingDTO.getTypeArrays()));
        if (buildingDTO.getBase64() != null) {
            writeImage(buildingDTO, buildingEntity);

        }
        buildingEntity = buildingRepository.save(buildingEntity);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateBuilding) {
        BuildingEntity existBuilding= buildingRepository.findOne(updateBuilding.getId());
        BuildingEntity updateBuildingEntity = buildingConverter.convertToEntity(updateBuilding);
        updateBuildingEntity.setCreatedDate(existBuilding.getCreatedDate());
        updateBuildingEntity.setCreatedBy(existBuilding.getCreatedBy());
        if (updateBuilding.getBase64() != null) {
            writeImage(updateBuilding, updateBuildingEntity);
        }
        else{
            updateBuildingEntity.setImage(existBuilding.getImage());
        }

        existBuilding = buildingRepository.save(updateBuildingEntity);
        return buildingConverter.convertToDto(existBuilding);
    }

    private void writeImage(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        byte[] bytes = Base64.decodeBase64(buildingDTO.getBase64().getBytes());
        String path = "/estate/" + buildingDTO.getImageName();
        UploadFileUtils.writeOrUpdate(path, bytes);
        buildingEntity.setImage(SystemConstant.HOME_BUILDING + path);

    }

    @Override
    public BuildingDTO findById(long id) {
        BuildingEntity newEntity = buildingRepository.findOne(id);
        return buildingConverter.convertToDto(newEntity);
    }


    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> results = new HashMap<>();
        Stream.of(BuildingType.values()).forEach(type -> {
            results.put(type.name(), type.getValue());
        });
        return results;
    }

    @Override
    public Long[] findUserAssignments(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        Long[] userAssignments = new Long[buildingEntity.getStaffs().size()];

        return userAssignments;
    }

}
