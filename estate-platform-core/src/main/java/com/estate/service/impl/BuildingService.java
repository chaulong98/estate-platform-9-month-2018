package com.estate.service.impl;

import com.estate.converter.BuildingConverter;
import com.estate.dto.AbstractDTO;
import com.estate.dto.BuildingDTO;
import com.estate.entity.BaseEntity;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.UserRepository;
import com.estate.security.utils.UploadFileUtils;
import com.estate.service.IBuildingService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter converter;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    public Long getTotalItems() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM BuildingEntity");
        return (Long) query.getResultList().get(0);
    }

    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> buildings = buildingRepository.findAll(pageable).getContent();
        model.setListResult(buildings.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList()));
        model.getListResult().sort(Comparator.comparing(AbstractDTO::getId));
        model.setTotalItems(getTotalItems().intValue());
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
    public void assignStaff(long[] userID, long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findOneById(buildingId);
        List<UserEntity> list = Arrays.stream(userID).mapToObj(id -> userRepository.findOneById(id)).collect(Collectors.toList());
        buildingEntity.setStaffs(list);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public List<Long> getStaffBuilding(long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        List<Long> listUserId = buildingEntity.getStaffs().stream().map(BaseEntity::getId).collect(Collectors.toList());
        return listUserId;
    }
}
