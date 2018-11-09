package com.estate.converter;

import com.estate.dto.DistricDTO;
import com.estate.entity.DistricEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistricConverter {
    @Autowired
    private ModelMapper modelMapper;

    public DistricDTO convertToDto(DistricEntity entity) {
        DistricDTO result = modelMapper.map(entity, DistricDTO.class);
        return result;
    }

    public DistricEntity convertToEntity(DistricDTO dto) {
        DistricEntity result = modelMapper.map(dto, DistricEntity.class);
        return result;
    }
}
