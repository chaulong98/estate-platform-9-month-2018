package com.estate.converter;

import com.estate.dto.DistricDTO;
import com.estate.entity.DistrictEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistricConverter {
    @Autowired
    private ModelMapper modelMapper;

    public DistricDTO convertToDto(DistrictEntity entity) {
        DistricDTO result = modelMapper.map(entity, DistricDTO.class);
        return result;
    }

    public DistrictEntity convertToEntity(DistricDTO dto) {
        DistrictEntity result = modelMapper.map(dto, DistrictEntity.class);
        return result;
    }
}
