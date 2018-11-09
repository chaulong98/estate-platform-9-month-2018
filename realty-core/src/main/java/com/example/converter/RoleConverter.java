package com.example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.model.RoleModel;
import com.example.model.UserModel;

public class RoleConverter {

	@Autowired
	private ModelMapper modelMapper;
	public RoleModel convertToDto(RoleEntity entity) {
		RoleModel result = modelMapper.map(entity, RoleModel.class);
		return result;
	}

	public RoleEntity convertToEntity(RoleModel dto) {
		RoleEntity result = modelMapper.map(dto, RoleEntity.class);
		return result;
	}
}
