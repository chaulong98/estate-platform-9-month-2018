package com.example.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.RoleEntity;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
@Service
public class RoleServiceimpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public Map<String, String> getRoles() {
		List<RoleEntity> entities = roleRepository.findAll();
		Map<String, String> map = new HashMap<>();
		for (RoleEntity item : entities) {
			map.put(item.getCode(), item.getName());
		}
		return map;
	}

}
