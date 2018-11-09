package com.example.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.DistrictEntity;
import com.example.repository.DistrictRepository;
import com.example.service.DistrictService;
@Service
public class DictrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;
	@Override
	public Map<String, String> getAllDictrict() {
		List<DistrictEntity> districtEntity = districtRepository.findAll();
		Map<String, String> map = new HashMap<>();
		for (DistrictEntity item : districtEntity) {
			map.put(item.getCode(), item.getName());
		}
		return map;
	}

}
