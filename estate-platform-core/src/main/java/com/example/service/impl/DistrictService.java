package com.example.service.impl;

import com.example.converter.DistrictConverter;
import com.example.dto.DistrictDTO;
import com.example.dto.UserDTO;
import com.example.entity.DistrictEntity;
import com.example.repository.DistrictRepository;
import com.example.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictService implements IDistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DistrictConverter districtConverter;

    @Override
    public List<DistrictDTO> findAll() {
        List<DistrictDTO> districts = districtRepository.findAll()
                .stream().map(item -> districtConverter.convertToDto(item)).collect(Collectors.toList());
        return  districts;
    }
}
