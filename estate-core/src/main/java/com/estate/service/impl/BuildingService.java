package com.estate.service.impl;

import com.estate.converter.BuildingConverter;
import com.estate.dto.BuildingDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.DistrictEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.DistrictRepository;
import com.estate.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter converter;

    @Autowired
    private DistrictRepository districtRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Long getTotalItems() {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);
    }

    public void findAll(BuildingDTO model, Pageable pageable) {
        List<BuildingEntity> news = buildingRepository.findAll(pageable).getContent();
        model.setListResult(news.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItems(getTotalItems().intValue());
    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        DistrictEntity district = districtRepository.findOneByCode(buildingDTO.getDistrict());
        BuildingEntity buildingEntity = converter.convertToEntity(buildingDTO);
        buildingEntity.setDistrict(district.toString());
        buildingRepository.save(buildingEntity);
        return converter.convertToDto(buildingEntity);
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateBuilding) {
        BuildingEntity existBuilding = buildingRepository.findOne(updateBuilding.getId());
        BuildingEntity update = converter.convertToEntity(updateBuilding);
        update.setDistrict(districtRepository.findOneByCode(updateBuilding.getDistrict()).toString());
        update.setCreatedDate(existBuilding.getCreatedDate());
        update.setCreatedBy(existBuilding.getCreatedBy());
        existBuilding = buildingRepository.save(update);
        return converter.convertToDto(existBuilding);
    }

    @Override
    public BuildingDTO findById(long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        return converter.convertToDto(buildingEntity);
    }
}
