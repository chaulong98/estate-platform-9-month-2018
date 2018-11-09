package com.example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.DistrictEntity;

import com.example.model.DistrictModel;

public class DistricConverter {

	@Autowired
	private ModelMapper modelMapper;

	public DistrictModel convertToDto(DistrictEntity entity) {
		DistrictModel result = modelMapper.map(entity, DistrictModel.class);
		return result;
	}

	public DistrictEntity convertToEntity(DistrictModel dto) {
		DistrictEntity result = modelMapper.map(dto, DistrictEntity.class);
		return result;
	}
}
