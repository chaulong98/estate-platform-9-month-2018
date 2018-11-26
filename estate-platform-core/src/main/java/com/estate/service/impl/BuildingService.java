package com.estate.service.impl;

import com.estate.constant.BuildingType;
import com.estate.constant.SystemConstant;
import com.estate.converter.BuildingConverter;
import com.estate.dto.BuildingDTO;
import com.estate.dto.UserDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.DistrictRepository;
import com.estate.repository.UserRepository;
import com.estate.service.IBuildingService;
import com.estate.utils.SecurityUtils;
import com.estate.utils.UploadFileUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private UserRepository userRepository;

    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> builds = buildingRepository.findAll(pageable).getContent();
        model.setListResult(builds.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItem(buildingRepository.getTotalItems().intValue());
    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingEntity.setType(String.join(",", buildingDTO.getTypeBuilding()));
        if (buildingDTO.getBase64Image() != null) {
            writeImage(buildingDTO, buildingEntity);
        }
        buildingEntity = buildingRepository.save(buildingEntity);
        return buildingConverter.convertToDto(buildingEntity);
    }

    private void writeImage(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        byte[] bytes = Base64.decodeBase64(buildingDTO.getBase64Image());
        String path = "/building/" + buildingDTO.getImageName();
        UploadFileUtils.writeOrUpdate(path, bytes);
        buildingEntity.setImage(SystemConstant.HOME_ESTATE + path);
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateDTO) {
        BuildingEntity exitBuilding = new BuildingEntity();
        exitBuilding = buildingRepository.findOne(updateDTO.getId());
        BuildingEntity updateBuilding = buildingConverter.convertToEntity(updateDTO);
        updateBuilding.setCreatedBy(exitBuilding.getCreatedBy());
        updateBuilding.setCreatedDate(exitBuilding.getCreatedDate());
        updateBuilding.setType(String.join(",", updateDTO.getTypeBuilding()));
        updateBuilding.setUsers(exitBuilding.getUsers());
        if (updateDTO.getBase64Image() != null) {
            writeImage(updateDTO, updateBuilding);
        } else {
            updateBuilding.setImage(exitBuilding.getImage());
        }
        exitBuilding = buildingRepository.save(updateBuilding);
        return buildingConverter.convertToDto(exitBuilding);
    }

    @Override
    public BuildingDTO findOneId(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        BuildingDTO dto = new BuildingDTO();
        dto = buildingConverter.convertToDto(buildingEntity);
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

    @Override
    @Transactional
    public void deleteBuilding(long[] id) {
        for (long item : id) {
            buildingRepository.delete(item);
        }
    }

    @Override
    @Transactional
    public void assignStaffsToBuilding(Long buildingId, long[] userIds) {
        List<UserEntity> users = new ArrayList<>();
        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        for (long id : userIds) {
            UserEntity userEntity = userRepository.findOne(id);
            users.add(userEntity);
        }
        buildingEntity.setUsers(users);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public void findBuildingByUsers(BuildingDTO model) {
        List<BuildingEntity> builds = buildingRepository.findAllByUsers(userRepository.findOneByUserName(SecurityUtils.getPrincipal().getUsername()));
        model.setListResult(builds.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItem(buildingRepository.getTotalItems().intValue());
    }
}
