package com.example.service.impl;

import com.example.converter.BuildingConverter;
import com.example.converter.UserConverter;
import com.example.dto.BuildingDTO;
import com.example.dto.UserDTO;
import com.example.entity.BuildingEntity;
import com.example.entity.UserEntity;
import com.example.repository.BuildingRepository;
import com.example.repository.UserRepository;
import com.example.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService{

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserService userService;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(pageable).getContent();
        List<BuildingDTO> buildingDTOS = new ArrayList<>();
        for(BuildingEntity entity : buildingEntities){
            BuildingDTO dto = buildingConverter.convertToDto(entity);
            buildingDTOS.add(dto);
        }
        model.setListResult(buildingDTOS);
        model.setTotalPages((int) Math.ceil((double) (buildingRepository.count())/(model.getMaxPageItems())));
    }

    public BuildingDTO findById(Long id){
        BuildingEntity entity = buildingRepository.findOne(id);
        BuildingDTO model = buildingConverter.convertToDto(entity);
        if(entity.getType() != null) {
            model.setProductType(entity.getType().split(","));
        }
        return model;
    }

    @Override
    public BuildingDTO save(BuildingDTO NewDto) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(NewDto);
        buildingEntity.setType(String.join(",", NewDto.getProductType()));
        buildingEntity = buildingRepository.save(buildingEntity);

        // help testing postman
        BuildingDTO model = buildingConverter.convertToDto(buildingEntity);
        if(buildingEntity.getType() != null) {
            model.setProductType(buildingEntity.getType().split(","));
        }
        return model;
    }

    @Override
    public BuildingDTO update(BuildingDTO updateDto) {
        BuildingEntity updateEntity = buildingConverter.convertToEntity(updateDto);
        BuildingEntity existEntity = buildingRepository.findOne(updateDto.getId());
        updateEntity.setStaffs(existEntity.getStaffs());
        updateEntity.setType(String.join(",", updateDto.getProductType()));
        existEntity = buildingRepository.save(updateEntity);

        // help testing postman
        BuildingDTO model = buildingConverter.convertToDto(existEntity);
        if(existEntity.getType() != null) {
            model.setProductType(existEntity.getType().split(","));
        }
        return model;
    }

    @Override
    public List<UserDTO> getStaff(String roleCode, Long buildingId) {
        List<UserDTO> users = userRepository.findByStatusAndRoles_Code(1, roleCode)
                                .stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
        for (UserDTO item: users) {
            boolean isChecked = userRepository.existsByUserNameAndBuildingsId(item.getUserName(), buildingId);
            if (isChecked) {
                item.setChecked("checked");
            }
        }
        return users;
    }

    @Override
    public BuildingDTO assignBuilding(long[] staffIds, Long buildingId) {
        /*String[] listUserId = dto.getListId();
        List<UserDTO> userDTOS = userService.findByListId(listUserId);
        List<UserEntity> userEntities = new ArrayList<>();
        for(UserDTO userDTO : userDTOS){
            UserEntity entity = userConverter.convertToEntity(userDTO);
            userEntities.add(entity);
        }

        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        buildingEntity.setStaffs(userEntities);
        buildingEntity = buildingRepository.save(buildingEntity);

        // help testing postman
        BuildingDTO model = buildingConverter.convertToDto(buildingEntity);
        if(buildingEntity.getType() != null) {
            model.setProductType(buildingEntity.getType().split(","));
        }
        return model;*/
        return null;
    }
}
