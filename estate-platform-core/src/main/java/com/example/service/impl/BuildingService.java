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
import com.example.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
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
        /*List<UserDTO> listAllStaff = userService.findbyRoleCode(roleCode);
        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        List<UserEntity> listAssignedStaffEntity = buildingEntity.getStaffs();
        List<UserDTO> listAssignedStaffDto = new ArrayList<>();
        for(UserEntity entity : listAssignedStaffEntity){
            UserDTO dto = userConverter.convertToDto(entity);
            listAssignedStaffDto.add(dto);
        }
        Set<Long> listIdAssignedStaff = new HashSet<>();
        for(UserDTO dto : listAssignedStaffDto){
            listIdAssignedStaff.add(dto.getId());
        }
        for(UserDTO dto : listAllStaff) {
            if (listIdAssignedStaff.contains(dto.getId())) {
                dto.setChecked("checked");
            }
        }
        return  listAllStaff;*/


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
        List<UserDTO> userDTOS = userService.findByListId(staffIds);
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
        return model;
    }

    @Override
    public void addPriorityBuilding(Long buildingId) {
        UserEntity curentUser = userRepository.findOne(SecurityUtils.getPrincipal().getId());
        BuildingEntity currentBuilding = buildingRepository.findOne(buildingId);
        currentBuilding.setPriority(true);
        buildingRepository.save(currentBuilding);
        /*curentUser.getBuildings().add(currentBuilding);
        userRepository.save(curentUser);*/
        List<BuildingEntity> buildingEntities = new ArrayList<>();
        buildingEntities.add(currentBuilding);
        curentUser.setBuildings(buildingEntities);
        userRepository.save(curentUser);
    }

    @Override
    public void deletePriorityBuilding(Long buildingId) {
        UserEntity curentUser = userRepository.findOne(SecurityUtils.getPrincipal().getId());
        BuildingEntity currentBuilding = buildingRepository.findOne(buildingId);
        currentBuilding.setPriority(false);
        buildingRepository.save(currentBuilding);
        List<BuildingEntity> buildingEntities = new ArrayList<>();
        buildingEntities.add(currentBuilding);
        curentUser.setBuildings(buildingEntities);
        curentUser = userRepository.save(curentUser);


        //Hard core th set list building vao user (it not works)
       /* UserEntity curentUser = userRepository.findOne(Long.valueOf(1));
        List<BuildingEntity> buildingEntities = new ArrayList<>();
        BuildingEntity bd1 = buildingRepository.findOne(Long.valueOf(1));
        BuildingEntity bd2 = buildingRepository.findOne(Long.valueOf(2));
        BuildingEntity bd3 = buildingRepository.findOne(Long.valueOf(3));
        BuildingEntity bd4 = buildingRepository.findOne(Long.valueOf(4));
        buildingEntities.add(bd1);
        buildingEntities.add(bd2);
        buildingEntities.add(bd3);
        buildingEntities.add(bd4);
        curentUser.setBuildings(buildingEntities);
        curentUser = userRepository.save(curentUser);*/

        //Hard core th set list user vao builind (it works)
        /*BuildingEntity buildingEntity = buildingRepository.findOne(Long.valueOf(2));
        List<UserEntity> userEntities = new ArrayList<>();
        UserEntity us1 = userRepository.findOne(Long.valueOf(1));
        UserEntity us2 = userRepository.findOne(Long.valueOf(2));
        UserEntity us3 = userRepository.findOne(Long.valueOf(3));
        userEntities.add(us1);
        userEntities.add(us2);
        userEntities.add(us3);
        buildingEntity.setStaffs(userEntities);
        buildingEntity = buildingRepository.save(buildingEntity);*/
    }
}
