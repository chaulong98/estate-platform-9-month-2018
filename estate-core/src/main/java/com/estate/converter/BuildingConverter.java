package com.estate.converter;

import com.estate.dto.BuildingDTO;
import com.estate.entity.BuildingEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {
	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO convertToDto(BuildingEntity entity) {
		BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
		return result;
	}

	public BuildingEntity convertToEntity(BuildingDTO userDTO) {
		BuildingEntity result = modelMapper.map(userDTO, BuildingEntity.class);
		return result;
	}
}
