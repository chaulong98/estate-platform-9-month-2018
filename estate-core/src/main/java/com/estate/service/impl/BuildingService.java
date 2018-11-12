package com.estate.service.impl;

import com.estate.builder.BuildingBuilder;
import com.estate.converter.BuildingConverter;
import com.estate.dto.BuildingDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.entity.enumtype.BuildingType;
import com.estate.page.PageRequest;
import com.estate.page.Pageable;
import com.estate.repository.BuildingRepository;
import com.estate.repository.UserRepository;
import com.estate.security.util.SecurityUtils;
import com.estate.service.IBuildingService;
import com.estate.utils.UploadFileUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private UploadFileUtils uploadFileUtils;

	@Autowired
	private UserRepository userRepository;


	@Override
	public BuildingDTO findById(long id) {
		BuildingEntity buildingEntity = buildingRepository.findOne(id);
		BuildingDTO result = buildingConverter.convertToDto(buildingEntity);
		if (buildingEntity.getTypeProduction() != null) {
			result.setTypeArrays(buildingEntity.getTypeProduction().split(","));
		}
		return result;
	}

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> results = new HashMap<>();
		Stream.of(BuildingType.values()).forEach(type -> {
			results.put(type.name(), type.getName());
		});
		return results;
	}

	@Override
	@Transactional
	public BuildingDTO save(Long id, BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		if (id != null) {
			BuildingEntity existBuilding = buildingRepository.findOne(id);
			buildingEntity = buildingConverter.convertToEntity(buildingDTO);
			buildingEntity.setCreatedDate(existBuilding.getCreatedDate());
			buildingEntity.setCreatedBy(existBuilding.getCreatedBy());
			buildingEntity.setImage(existBuilding.getImage());
			buildingEntity.setStaffs(existBuilding.getStaffs());
			buildingEntity.setUsers(existBuilding.getUsers());
		} else {
			buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		}
		saveImage(buildingEntity, buildingDTO);
		if (buildingDTO.getTypeArrays() != null && buildingDTO.getTypeArrays().length > 0) {
			buildingEntity.setTypeProduction(String.join(",", buildingDTO.getTypeArrays()));
		}
		buildingEntity = buildingRepository.save(buildingEntity);
		return buildingConverter.convertToDto(buildingEntity);
	}

	@Override
	public List<BuildingDTO> findAll(BuildingDTO model) {
		if (model.getLink().equals("/admin/building/assignment")) {
			model.setCreatedBy(SecurityUtils.getPrincipal().getUsername());
			model.setStaffName(SecurityUtils.getPrincipal().getUsername());
		}
		if (StringUtils.isNotBlank(model.getStaffName())) {
			model.setStaffId(userRepository.findOneByUserName(model.getStaffName()).getId());
		}
		List<BuildingEntity> buildings =  buildingRepository.findAll(getBuildingBuilder(model), new PageRequest(model.getPage(), model.getMaxPageItems()));
		return convertToBuildingDTOS(buildings);
	}

	private List<BuildingDTO> convertToBuildingDTOS(List<?> buildings) {
		List<BuildingDTO> buildingDTOS = new ArrayList<>();
		if (buildings == null) return new ArrayList<>();
		for (Object item : buildings) {
			BuildingEntity buildingEntity = (BuildingEntity) item;
			BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingEntity);
			if (buildingEntity.getStaffs().stream().anyMatch(entity -> entity.getUserName().equals(SecurityUtils.getPrincipal().getUsername())) ||
					buildingEntity.getCreatedBy().equals(SecurityUtils.getPrincipal().getUsername())) {
				buildingDTO.setEditBuilding(true);
			}
			buildingDTO.setAddress(buildingDTO.getStreet() + " " + buildingDTO.getTownShip() + " " + buildingDTO.getDistrict());
			buildingDTO.setPriority(true);
			buildingDTOS.add(buildingDTO);
		}
		return buildingDTOS;
	}

	@Override
	public int getTotalItems(BuildingDTO model) {
		if ("/admin/building/assignment".equals(model.getLink())) {
			int total1 = buildingRepository.getTotalItems(getBuildingBuilder(model)).intValue();
			model.setStaffName(null);
			model.setCreatedBy(SecurityUtils.getPrincipal().getUsername());
			int total2 = buildingRepository.getTotalItems(getBuildingBuilder(model)).intValue();
			return total1 + total2;
		} else {
			return buildingRepository.getTotalItems(getBuildingBuilder(model)).intValue();
		}
	}

	@Override
	@Transactional
	public void assignUserToBuilding(long[] userIds, long buildingId) {
		BuildingEntity building = buildingRepository.findOne(buildingId);
		List<UserEntity> staffs = new ArrayList<>();
		for (long item : userIds) {
			staffs.add(userRepository.findOne(item));
		}
		building.setStaffs(staffs);
		buildingRepository.save(building);
	}

	@Override
	@Transactional
	public void updatePriority(String action, long id) {
		UserEntity user = userRepository.findOneByUserName(SecurityUtils.getPrincipal().getUsername());
		BuildingEntity building = buildingRepository.findOne(id);
		if ("insert".equals(action)) {
			building.setUsers(Stream.of(user).collect(Collectors.toList()));
			user.setBuildingPriorities(Stream.of(building).collect(Collectors.toList()));
		} else if ("remove".equals(action)) {
			user.getBuildingPriorities().remove(building);
			building.getUsers().remove(user);
		}
		buildingRepository.save(building);
		userRepository.save(user);
	}

	@Override
	public List<BuildingDTO> findAllPriorities(long userId, Pageable pageable) {
		Page<BuildingEntity> buildingsPage = buildingRepository.findByUsers_Id(userId, pageable);
		return buildingsPage.getContent().stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());
	}

	@Override
	public int getTotalItemPriorities(long userId) {
		return (int) buildingRepository.countByUsers_Id(userId);
	}

	private BuildingBuilder getBuildingBuilder(BuildingDTO model) {
		return new BuildingBuilder.Builder()
				.setAreaFrom(model.getAreaFrom())
				.setAreaTo(model.getAreaTo())
				.setNumberOfBasement(model.getNumberOfBasement())
				.setCostFrom(model.getCostFrom())
				.setCostTo(model.getCostTo())
				.setDirection(model.getWay())
				.setDistrict(model.getDistrict())
				.setLevel(model.getRank())
				.setProvince(model.getTownShip())
				.setStreet(model.getStreet())
				.setTypes(model.getTypeArrays())
				.build();
	}

	private void saveImage(BuildingEntity buildingEntity, BuildingDTO buildingDTO) {
		if (buildingDTO.getThumbnailBase64() != null) {
			byte[] decodedBase64 = Base64.decodeBase64(buildingDTO.getThumbnailBase64().getBytes());
			String path = "/building" + "/" + buildingDTO.getImageName();
			uploadFileUtils.writeOrUpdate(path, decodedBase64);
			buildingEntity.setImage(path);
		}
	}
}
