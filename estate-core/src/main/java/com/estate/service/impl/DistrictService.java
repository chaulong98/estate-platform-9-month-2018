package com.estate.service.impl;

import com.estate.converter.DistrictConverter;
import com.estate.dto.DistrictDTO;
import com.estate.repository.DistrictRepository;
import com.estate.service.IDistrictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService implements IDistrictService {
	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private DistrictConverter districtConverter;

	@Override
	public List<DistrictDTO> findDistrictsByName(String name) {
		List<DistrictDTO> districtDTOS = new ArrayList<>();
		districtRepository.findAll().forEach(item -> {
			if (StringUtils.isNotBlank(name) && item.getName().toLowerCase().contains(name.toLowerCase())) {
				districtDTOS.add(districtConverter.convertToDto(item));
			}
		});
		return districtDTOS;
	}
}
