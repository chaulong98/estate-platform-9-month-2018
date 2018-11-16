package com.example.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.constant.SystemConstant;
import com.example.converter.BuidingConverter;
import com.example.entity.BuildingEntity;

import com.example.entity.UserEntity;
import com.example.model.BuildingModel;
import com.example.repository.BuildingRepository;
import com.example.repository.UserRepository;
import com.example.service.BuildingService;
import com.example.utils.UploadFileUtils;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuidingConverter converter;
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public List<BuildingModel> getAllBuilding(Pageable pageable) {
		Page<BuildingEntity> page = buildingRepository.findAll(pageable);
		List<BuildingEntity> listEntitys = page.getContent();
		List<BuildingModel> buildingModels = new ArrayList<>();
		for (BuildingEntity item : listEntitys) {
			buildingModels.add(converter.convertToDto(item));
		}
		return buildingModels;

	}

	@Override
	@Transactional
	public BuildingModel insertBuilding(BuildingModel model) {
		BuildingEntity buildingEntity = converter.convertToEntity(model);
		String productType = "";
		for (int i = 0; i < model.getProductTypeModel().length; i++) {
			productType += model.getProductTypeModel()[i] + " ";
		}

		buildingEntity.setProductType(productType);
		if (model.getBase64Image() != null) {
			byte[] decodeBase64 = Base64.decodeBase64(model.getBase64Image().getBytes());
			String path = "/test/" + model.getImageName();
			UploadFileUtils.writeOrUpdate(path, decodeBase64);
			buildingEntity.setThumbnail(SystemConstant.HOME_BUILDING + path);
		}
		BuildingModel buildingModel = converter.convertToDto(buildingRepository.save(buildingEntity));
		return buildingModel;

	}

	@Override
	@Transactional
	public BuildingModel findBuilding(Long id) {
		BuildingEntity buildingEntity = buildingRepository.findOne(id);
		BuildingModel buildingModel = converter.convertToDto(buildingEntity);
		Long[] manager = new Long[buildingEntity.getUserEntity().size()];
		String[] productType = buildingEntity.getProductType().split("\\s");
		buildingModel.setThumbnail(buildingModel.getThumbnail().split("/")[4]);
		int i = 0;
		for (UserEntity items : buildingEntity.getUserEntity()) {
			manager[i] = items.getId();
			i++;
		}
		// productType[0] = buildingEntity.getProductType();

		buildingModel.setDependencies(manager);
		buildingModel.setProductTypeModel(productType);
		return buildingModel;

	}

	@Override
	@Transactional
	public BuildingModel updateBuilding(Long id, BuildingModel model) {
		BuildingEntity buildingEntity = buildingRepository.findOne(id);
		buildingEntity.setNameBuilding(model.getNameBuilding());
		buildingEntity.setFloorArea(model.getFloorArea());
		buildingEntity.setNumberBasement(model.getNumberBasement());
		buildingEntity.setDistrict(model.getDistrict());
		buildingEntity.setGuild(model.getGuild());
		buildingEntity.setStreet(model.getStreet());

		buildingEntity.setDirection(model.getDirection());
		buildingEntity.setRate(model.getRate());
		buildingEntity.setRentArea(model.getRentArea());

		buildingEntity.setDescriptionArea(model.getDescriptionArea());
		buildingEntity.setCostRent(model.getCostRent());

		buildingEntity.setPriceDescription(model.getPriceDescription());

		buildingEntity.setServiceCharge(model.getServiceCharge());
		buildingEntity.setChargeCar(model.getChargeCar());
		buildingEntity.setChargeMoto(model.getChargeMoto());
		buildingEntity.setChangeOutTime(model.getChangeOutTime());
		buildingEntity.setElectricBill(model.getElectricBill());

		buildingEntity.setDeposit(model.getDeposit());

		buildingEntity.setPay(model.getPay());

		buildingEntity.setTimeout(model.getTimeout());

		buildingEntity.setDecorateTime(model.getDecorateTime());
		buildingEntity.setManagementName(model.getManagementName());
		buildingEntity.setManagementPhone(model.getManagementPhone());
		buildingEntity.setNote(model.getNote());
		String productType = "";
		for (int i = 0; i < model.getProductTypeModel().length; i++) {
			productType += model.getProductTypeModel()[i] + " ";
		}
		buildingEntity.setProductType(productType);

		if (model.getBase64Image() != null) {
			byte[] decodeBase64 = Base64.decodeBase64(model.getBase64Image().getBytes());
			String path = "/test/" + model.getImageName();
			UploadFileUtils.writeOrUpdate(path, decodeBase64);

			String path2 = buildingEntity.getThumbnail();
			File file2 = new File(path2);
			file2.delete();

			buildingEntity.setThumbnail(SystemConstant.HOME_BUILDING + path);
		} else {
			
			buildingEntity.setThumbnail(buildingEntity.getThumbnail());
		}

		BuildingEntity entity = buildingRepository.save(buildingEntity);

		return converter.convertToDto(entity);

	}

	@Override
	@Transactional
	public BuildingModel editManager(Long id, BuildingModel model) {
		BuildingEntity buildingEntity = buildingRepository.findOne(id);
		List<UserEntity> userEntity = new ArrayList<>();
		for (int i = 0; i < model.getDependencies().length; i++) {
			UserEntity entity = userRepository.findOne(model.getDependencies()[i]);
			userEntity.add(entity);
		}

		buildingEntity.setUserEntity(userEntity);
		BuildingEntity entity = buildingRepository.save(buildingEntity);
		return converter.convertToDto(entity);
	}

	 @Transactional
	 public void deleteUserBuilding(long[] ids) {
	for (long item : ids) {
		buildingRepository.delete(item);
	}
	
	 }

}
