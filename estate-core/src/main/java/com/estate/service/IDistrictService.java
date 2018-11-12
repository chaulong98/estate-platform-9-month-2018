package com.estate.service;

import com.estate.dto.DistrictDTO;

import java.util.List;

public interface IDistrictService {
	List<DistrictDTO> findDistrictsByName(String name);
}
