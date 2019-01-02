package com.estate.service.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.converter.BuildingConverter;
import com.estate.dto.AbstractDTO;
import com.estate.dto.BuildingDTO;
import com.estate.entity.BaseEntity;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.UserRepository;
import com.estate.repository.custom.CustomBuildingRepository;
import com.estate.security.utils.SecurityUtils;
import com.estate.security.utils.UploadFileUtils;
import com.estate.service.IBuildingService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter converter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomBuildingRepository customBuildingRepository;

    @Override
    public List<BuildingDTO> findAll(BuildingDTO model, com.estate.repository.paging.Pageable pageable) {
        List<BuildingEntity> buildings = customBuildingRepository.findAll(getBuildingBuilder(model), pageable);
        List<BuildingDTO> buildingDTOS = buildings.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList());
        for(BuildingDTO dto: buildingDTOS){
            if(userRepository.existsByIdAndPriorityBuildings_Id(SecurityUtils.getPrincipal().getId(),dto.getId())){
                dto.setIsPriority(true);
            }
        }
        return buildingDTOS;
    }

    private BuildingBuilder getBuildingBuilder(BuildingDTO model) {
        return new BuildingBuilder.Builder()
                .setBasement(model.getBasement())
                .setName(model.getName())
                .setDistrict(model.getDistrict())
                .setFloorArea(model.getFloorArea())
                .setDirection(model.getDirection())
                .setGrade(model.getGrade())
                .setManagerName(model.getManagerName())
                .setStreet(model.getStreet())
                .setWard(model.getWard())
                .setCostFrom(model.getCostFrom())
                .setCostTo(model.getCostTo())
                .setAreaFrom(model.getAreaFrom())
                .setAreaTo(model.getAreaTo())
                .setType(model.getType())
                .setStaffId(StringUtils.isNotBlank(model.getStaffName()) ? Long.valueOf(model.getStaffName()) : null)
                .build();
    }

    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> buildings = buildingRepository.findAll(pageable).getContent();
        List<BuildingDTO> buildingDTOS = buildings.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList());
        model.setListResult(buildingDTOS);
        for(BuildingDTO dto: buildingDTOS){
            if(userRepository.existsByIdAndPriorityBuildings_Id(SecurityUtils.getPrincipal().getId(),dto.getId())){
                dto.setIsPriority(true);
            }
        }
        model.getListResult().sort(Comparator.comparing(AbstractDTO::getId));
        model.setTotalItems(customBuildingRepository.getTotalItems().intValue());
    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = converter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
        if (buildingDTO.getBase64() != null) {
            writeImg(buildingDTO, buildingEntity);
        }
        return converter.convertToDto(buildingEntity);
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateBuilding) {
        BuildingEntity existBuilding = buildingRepository.findOne(updateBuilding.getId());
        BuildingEntity update = converter.convertToEntity(updateBuilding);
        update.setCreatedDate(existBuilding.getCreatedDate());
        update.setCreatedBy(existBuilding.getCreatedBy());
        if (updateBuilding.getBase64() != null) {
            writeImg(updateBuilding, update);
        } else {
            update.setAvatar(existBuilding.getAvatar());
        }
        existBuilding = buildingRepository.save(update);
        return converter.convertToDto(existBuilding);
    }

    private void writeImg(BuildingDTO updateBuilding, BuildingEntity updateEntity) {
        byte[] decodedBase64 = Base64.decodeBase64(updateBuilding.getBase64().getBytes());
        String path = updateBuilding.getImgName();
        UploadFileUtils.writeOrUpdate(path, decodedBase64);
        updateEntity.setAvatar("/anh/test/" + path);
    }

    @Override
    public BuildingDTO findById(long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        return converter.convertToDto(buildingEntity);
    }

    @Override
    @Transactional
    public void assignStaff(long[] userID, long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findOneById(buildingId);
        List<UserEntity> list = Arrays.stream(userID).mapToObj(id -> userRepository.findOneById(id)).collect(Collectors.toList());
        buildingEntity.setStaffs(list);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public List<Long> getStaffBuilding(long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        return buildingEntity.getStaffs().stream().map(BaseEntity::getId).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updatePriority(long buildingId, String action) {
        BuildingEntity buildingEntity = buildingRepository.findOneById(buildingId);
        UserEntity user = userRepository.findOneById(SecurityUtils.getPrincipal().getId());
        if(action.equals("insert")&&buildingEntity.getUsers().stream().map(BaseEntity::getId).noneMatch(user.getId()::equals)){
            buildingEntity.getUsers().add(user);
        }else if (action.equals("remove")){
            buildingEntity.getUsers().remove(user);
        }
        buildingRepository.save(buildingEntity);
    }

    @Override
    public List<BuildingDTO> findPriorityBuildings(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> buildings = buildingRepository.findAll(pageable).getContent();
        List<BuildingDTO> buildingDTOS = buildings.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList());
        for(BuildingDTO dto: buildingDTOS){
            if(userRepository.existsByIdAndPriorityBuildings_Id(SecurityUtils.getPrincipal().getId(),dto.getId())){
                dto.setIsPriority(true);
                model.getListResult().add(dto);
            }
        }
        return model.getListResult();
    }

}
