package com.estate.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.estate.security.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estate.converter.RoleConverter;
import com.estate.entity.RoleEntity;
import com.estate.repository.RoleRepository;
import com.estate.dto.RoleDTO;
import com.estate.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;


	@Override
	public String getRoles() {
		List<String> roles = SecurityUtils.getAuthorities();
		if (roles.contains("ADMIN")) {
				return "ADMIN";
		} else if (roles.contains("USER")) {
			return "USER";
		}
		return null;
	}
}
