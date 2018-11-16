package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.converter.UserConverter;
import com.example.entity.UserEntity;
import com.example.model.MyUserDetail;
import com.example.model.RoleModel;
import com.example.model.UserModel;
import com.example.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final Logger log = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserName(username);
		UserModel userModel = userConverter.convertToDto(userEntity);
		
		if(userModel == null) {
			log.error("user not found");
			throw new UsernameNotFoundException("Username not found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleModel role: userModel.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));			
		}
		
		MyUserDetail myUserDetail = new MyUserDetail(username, userModel.getPassword(), true, true, true, true, authorities);
		BeanUtils.copyProperties(userModel, myUserDetail);
		return myUserDetail;
	}
	
}
