package com.estate.service.impl;

import com.estate.converter.UserConverter;
import com.estate.dto.MyUserDetail;
import com.estate.dto.UserDTO;
import com.estate.entity.UserEntity;
import com.estate.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomMyUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserConverter userConverter;


	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserName(s);
		UserDTO userDTO = userConverter.convertToDto(userEntity);
		if (userDTO == null){
			throw new UsernameNotFoundException("Don't find userName");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		userDTO.getRoles().forEach(roleDTO -> {
			authorities.add(new SimpleGrantedAuthority(roleDTO.getCode()));
		});
		MyUserDetail myUserDetail = new MyUserDetail(s, userDTO.getPassword(),true,true,true,true,authorities);
		BeanUtils.copyProperties(myUserDetail, userDTO);
		return myUserDetail;
	}
}
