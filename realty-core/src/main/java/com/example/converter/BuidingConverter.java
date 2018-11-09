package com.example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.BuildingEntity;

import com.example.model.BuildingModel;

@Component
public class BuidingConverter {
	@Autowired
	private ModelMapper modelMapper;

	public BuildingModel convertToDto(BuildingEntity entity) {
		BuildingModel result = modelMapper.map(entity, BuildingModel.class);
		return result;
	}

	public BuildingEntity convertToEntity(BuildingModel dto) {
		BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
		return result;
	}
}
