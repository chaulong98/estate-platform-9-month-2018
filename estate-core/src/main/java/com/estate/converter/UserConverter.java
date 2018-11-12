package com.estate.converter;

import com.estate.dto.UserDTO;
import com.estate.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
	@Autowired
	ModelMapper modelMapper;

	public UserDTO convertToDto(UserEntity entity) {
		UserDTO result = modelMapper.map(entity, UserDTO.class);
		return result;
	}

	public UserEntity convertToEntity(UserDTO userDTO) {
		UserEntity result = modelMapper.map(userDTO, UserEntity.class);
		return result;
	}
}
