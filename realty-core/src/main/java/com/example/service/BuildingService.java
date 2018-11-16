package com.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.model.BuildingModel;

public interface BuildingService {

	List<BuildingModel> getAllBuilding(Pageable pageable);
	BuildingModel insertBuilding(BuildingModel model);
	BuildingModel findBuilding(Long id);
	BuildingModel updateBuilding(Long id,BuildingModel model);
	BuildingModel editManager(Long id , BuildingModel model);
	void deleteUserBuilding(long[] ids);
}
