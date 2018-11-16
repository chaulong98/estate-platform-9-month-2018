package com.estate.converter;

import com.estate.dto.BuildingDTO;
import com.estate.entity.BuildingEntity;
import com.estate.enums.BuildingType;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO convertToDto(BuildingEntity entity) {
        BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        return result;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
//        String types = dto.getType();
//        String typeValues = "";
//        if (StringUtils.isNotBlank(types)) {
//            if (types.contains(",")) {
//                StringJoiner joiner = new StringJoiner(",");
//                Stream.of(types.split(",")).forEach(s ->
//                        joiner.add(BuildingType.valueOf(s).getValue())
//                );
//                typeValues = joiner.toString();
//            } else {
//                typeValues = BuildingType.valueOf(types).getValue();
//            }
//        }
//        result.setType(typeValues);
        return result;
    }
}
