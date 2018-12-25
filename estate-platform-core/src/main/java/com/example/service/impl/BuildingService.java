package com.example.service.impl;

import com.example.constant.SystemConstant;
import com.example.converter.BuildingConverter;
import com.example.converter.UserConverter;
import com.example.dto.BuildingDTO;
import com.example.dto.UserDTO;
import com.example.entity.BuildingEntity;
import com.example.entity.ManagementEntity;
import com.example.entity.UserEntity;
import com.example.repository.BuildingRepository;
import com.example.repository.ManagementRepository;
import com.example.repository.UserRepository;
import com.example.service.IBuildingService;
import com.example.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagementRepository managementRepository;


    @Override
    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(pageable).getContent();
        List<BuildingDTO> buildingDTOS = new ArrayList<>();
        for(BuildingEntity entity : buildingEntities){
            BuildingDTO dto = buildingConverter.convertToDto(entity);
            buildingDTOS.add(dto);
        }

        for(BuildingDTO dto : buildingDTOS){
            ManagementEntity managementEntity = managementRepository.findOneByUserEntityIdAndBuildingEntityId(SecurityUtils.getPrincipal().getId(), dto.getId());
            if(managementEntity != null){
                boolean priority = managementEntity.isPriority();
                dto.setPriority(priority);
            }
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
        //commend
        /*updateEntity.setStaffs(existEntity.getStaffs());*/
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
        List<UserDTO> listAllStaff = userRepository.findByStatusAndRoles_Code(1, roleCode)
                .stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        /*List<UserEntity> listAssignedStaffEntity = buildingEntity.getStaffs();*/
        List<ManagementEntity> managementEntities = managementRepository.findByBuildingEntityId(buildingId);
        List<UserEntity> userEntities = new ArrayList<>();
        for(ManagementEntity managementEntity : managementEntities){
            userEntities.add(managementEntity.getUserEntity());
        }

        List<UserDTO> listAssignedStaffDto = userEntities.stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());

        Set<Long> listIdAssignedStaff = new HashSet<>();
        for(UserDTO dto : listAssignedStaffDto){
            listIdAssignedStaff.add(dto.getId());
        }
        for(UserDTO dto : listAllStaff) {
            if (listIdAssignedStaff.contains(dto.getId())) {
                dto.setChecked("checked");
            }
        }
        return  listAllStaff;


        /*List<UserDTO> users = userRepository.findByStatusAndRoles_Code(1, roleCode)
                                .stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
        for (UserDTO item: users) {
            boolean isChecked = userRepository.existsByUserNameAndBuildingsId(item.getUserName(), buildingId);
            if (isChecked) {
                item.setChecked("checked");
            }
        }
        return users;*/
    }

    @Override
    public BuildingDTO assignBuilding(long[] staffIds, Long buildingId) {
        List<UserEntity> staffs = new ArrayList<>();
        for(long id : staffIds){
            staffs.add(userRepository.findOne(id));
        }

        BuildingEntity existBuilding = buildingRepository.findOne(buildingId);

        // List user managing the current building
        List<ManagementEntity> managementEntities = managementRepository.findByBuildingEntityId(buildingId);

        if(staffs.size() >= managementEntities.size()) {
            Set<Long> setId = new HashSet<>();
            for (ManagementEntity managementEntity : managementEntities) {
                setId.add(managementEntity.getUserEntity().getId());
            }

            for (UserEntity staff : staffs) {
                //danh sách truyền vào chưa có userEntity thì thêm vào bảng management
                if (!setId.contains(staff.getId())) {
                    ManagementEntity newManagementEntity = new ManagementEntity();
                    newManagementEntity.setBuildingEntity(existBuilding);
                    newManagementEntity.setUserEntity(staff);
                    managementRepository.save(newManagementEntity);
                }
            }
        }else{
            Set<Long> setId = new HashSet<>();
            for (UserEntity staff : staffs) {
                setId.add(staff.getId());
            }
            for(ManagementEntity managementEntity : managementEntities){
                // danh sách truyền vào không chứa userEntity trong bảng management thì xóa user trong bảng đi
                if (!setId.contains(managementEntity.getUserEntity().getId())) {
                    managementRepository.delete(managementEntity);
                }
            }
        }


        // help testing postman
        BuildingDTO model = buildingConverter.convertToDto(existBuilding);
        if(existBuilding.getType() != null) {
            model.setProductType(existBuilding.getType().split(","));
        }
        return model;
    }

    @Override
    public Integer addPriorityBuilding(Long buildingId) {
        List<String> roles = SecurityUtils.getAuthorities();
        if (isManager(roles)) {
            //Get list building which current user managing
            List<BuildingEntity> buildings = buildingRepository.findAll();
            for(BuildingEntity buildingEntity : buildings){
                if(buildingEntity.getId() == buildingId){
                    ManagementEntity existManagementEntity = managementRepository.findOneByUserEntityIdAndBuildingEntityId(SecurityUtils.getPrincipal().getId(), buildingId);
                    if(existManagementEntity != null){
                        existManagementEntity.setPriority(true);
                        managementRepository.save(existManagementEntity);
                        break;
                    }

                    ManagementEntity newManagementEntity = new ManagementEntity();
                    newManagementEntity.setBuildingEntity(buildingRepository.findOne(buildingId));
                    newManagementEntity.setUserEntity(userRepository.findOne(SecurityUtils.getPrincipal().getId()));
                    newManagementEntity.setPriority(true);
                    managementRepository.save(newManagementEntity);
                    break;
                }
            }
            return 1;
        } else{
            //Get list building which current user managing
            List<ManagementEntity> managementEntities = managementRepository.findByUserEntityId(SecurityUtils.getPrincipal().getId());
            if(managementEntities.size() == 0){
                return 0;
            }
            for(ManagementEntity managementEntity : managementEntities){
                if(managementEntity.getBuildingEntity().getId() == buildingId){
                    managementEntity.setPriority(true);
                    managementRepository.save(managementEntity);
                    break;
                }
            }
            return managementEntities.size();
        }
    }

    @Override
    public Integer deletePriorityBuilding(Long buildingId) {
        List<String> roles = SecurityUtils.getAuthorities();
        if (isManager(roles)) {
            //Get list building which current user managing
            List<BuildingEntity> buildings = buildingRepository.findAll();
            for(BuildingEntity buildingEntity : buildings){
                if(buildingEntity.getId() == buildingId){
                    ManagementEntity managementEntity = managementRepository.findOneByUserEntityIdAndBuildingEntityId(SecurityUtils.getPrincipal().getId(), buildingId);
                    if(managementEntity != null){
                        managementEntity.setPriority(false);
                        managementRepository.save(managementEntity);
                        break;
                    }

                    managementEntity.setBuildingEntity(buildingRepository.findOne(buildingId));
                    managementEntity.setUserEntity(userRepository.findOne(SecurityUtils.getPrincipal().getId()));
                    managementEntity.setPriority(false);
                    managementRepository.save(managementEntity);
                    break;
                }
            }
            return 1;
        } else{
            //Get list building which current user managing
            List<ManagementEntity> managementEntities = managementRepository.findByUserEntityId(SecurityUtils.getPrincipal().getId());
            if(managementEntities.size() == 0){
                return 0;
            }
            for(ManagementEntity managementEntity : managementEntities){
                if(managementEntity.getBuildingEntity().getId() == buildingId){
                    managementEntity.setPriority(false);
                    managementRepository.save(managementEntity);
                    break;
                }
            }
            return managementEntities.size();
        }
    }

    @Override
    public void findPriorityBuilding(BuildingDTO model, Pageable pageable) {
        //Lấy ra danh sách tòa nhà ưu tiên mà user đang quản lý có phân trang
        List<ManagementEntity> managementEntities = managementRepository.findByUserEntityIdAndIsPriority(SecurityUtils.getPrincipal().getId(), true, pageable).getContent();
        List<BuildingEntity> buildingEntities = new ArrayList<>();
        for(ManagementEntity item : managementEntities){
            buildingEntities.add(buildingRepository.findOne(item.getBuildingEntity().getId()));
        }
        List<BuildingDTO> buildingDTOS = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());

        model.setListResult(buildingDTOS);
        model.setTotalPages((int) Math.ceil((double) (managementRepository
                .findByUserEntityIdAndIsPriority(SecurityUtils.getPrincipal().getId(), true).size())/(model.getMaxPageItems())));
    }

    private boolean isManager(List<String> roles) {
        if (roles.contains(SystemConstant.MANAGER_ROLE)) {
            return true;
        }
        return false;
    }

    private boolean isUser(List<String> roles) {
        if (roles.contains(SystemConstant.USER_ROLE)) {
            return true;
        }
        return false;
    }
}
