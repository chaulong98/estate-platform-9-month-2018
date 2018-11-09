package com.example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.UserEntity;
import com.example.model.UserModel;

@Component
public class UserConverter {

	@Autowired
	private ModelMapper modelMapper;
	public UserModel convertToDto(UserEntity entity) {
		UserModel result = modelMapper.map(entity, UserModel.class);
		return result;
	}

	public UserEntity convertToEntity(UserModel dto) {
		UserEntity result = modelMapper.map(dto, UserEntity.class);
		return result;
	}
}
