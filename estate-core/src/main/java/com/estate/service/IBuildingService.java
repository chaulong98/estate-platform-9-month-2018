package com.estate.service;

import com.estate.dto.BuildingDTO;
import com.estate.page.Pageable;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
	BuildingDTO findById(long id);
	Map<String, String> getBuildingTypes();
	BuildingDTO save(Long id, BuildingDTO userDTO);
	List<BuildingDTO> findAll(BuildingDTO model);
	int getTotalItems(BuildingDTO model);
	void assignUserToBuilding(long[] userIds, long buildingId);
	void updatePriority(String action, long id);
	List<BuildingDTO> findAllPriorities(long userId, Pageable pageable);
	int getTotalItemPriorities(long userId);
}
