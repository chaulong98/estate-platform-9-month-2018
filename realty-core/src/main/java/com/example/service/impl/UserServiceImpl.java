package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.converter.UserConverter;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.model.UserModel;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.utils.RandomPassword;
import com.example.utils.SecurityUtils;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter converterUser;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<UserModel> getNews(String userName, String fullName, Pageable pageable) {
		Page<UserEntity> page = null;
		if (userName != null && StringUtils.isNotEmpty(userName)) {
			page = userRepository.findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(userName, fullName,pageable);
		} else {
			page = userRepository.findAll(pageable);
		}
		List<UserEntity> userEntities = page.getContent();
		List<UserModel> modelsList = new ArrayList<>();
		for (UserEntity item : userEntities) {
			modelsList.add(converterUser.convertToDto(item));
		}
		return modelsList;
	}

	@Override
	public long getTotalItems(String userName, String fullName) {
		long totalItem = 0;
		if (userName != null && StringUtils.isNotEmpty(userName)) {
			totalItem = userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(userName,
					fullName);
		} else {
			totalItem = userRepository.count();
		}
		return totalItem;
	}

	@Override
	public UserModel insertUser(UserModel model) {

		if (checkUserNameAndEmailUnique(model.getUserName(), model.getEmail(), model.getId())) {
			UserEntity userEntity = converterUser.convertToEntity(model);
			RoleEntity entityRole = roleRepository.findOneByCode(model.getSelectorRole());
			RoleEntity entityRole1 = roleRepository.findOneByCode("USER");
			List<RoleEntity> list = new ArrayList<>();
			list.add(entityRole);
			list.add(entityRole1);
			
			userEntity.setPassword(passwordEncoder.encode(RandomPassword.passWordRandom()));
			userEntity.setRoles(list);
			userEntity.setStatus(1);
			userEntity = userRepository.save(userEntity);
			// sendMail("hoanganhtien25041997@gmail.com","hello","mat lol");

			return converterUser.convertToDto(userEntity);

		} else {
			model.setCheckUserAndEmail(false);
			return model;
		}

	}

	@Override
	public UserModel updateUser(Long id, UserModel model) {

		if (checkUserNameAndEmailUnique(model.getUserName(), model.getEmail(), id)) {

			UserEntity userEntity = userRepository.findOne(id);
			RoleEntity entityRole = roleRepository.findOneByCode(model.getSelectorRole());
			List<RoleEntity> list = new ArrayList<>();
			list.add(entityRole);
			userEntity.setUserName(model.getUserName());
			userEntity.setPassword(passwordEncoder.encode(model.getPassword()));
			userEntity.setFullName(model.getFullName());
			userEntity.setEmail(model.getEmail());
			userEntity.setPhoneNumber(model.getPhoneNumber());
			userEntity.setStatus(model.getStatus());
			userEntity.setRoles(list);
			userEntity = userRepository.save(userEntity);
			return converterUser.convertToDto(userEntity);

		} else {
			model.setCheckUserAndEmail(false);
			return model;
		}
	}

	@Override
	public UserModel findUserById(Long id) {
		UserEntity entity = userRepository.findOne(id);
		UserModel model = converterUser.convertToDto(entity);
	    List<RoleEntity> entities = entity.getRoles();
	    String result = null;
	    for (RoleEntity item : entities) {
	    	result = item.getCode();
		}
	       model.setSelectorRole(result);
		
		return model;
	}

	@Override
	public Boolean checkUserNameAndEmailUnique(String userName, String email, Long idUser) {
		UserEntity nameUser = userRepository.findOneByUserName(userName);
		UserEntity emailUser = userRepository.findOneByEmail(email);
		if (idUser == null) {
			if (nameUser == null && emailUser == null) {
				return true;
			}
			return false;
		} else {

			if (nameUser != null && emailUser == null) {
				if (nameUser.getId() == idUser) {
					return true;
				} else {
					return false;
				}
			}

			if (nameUser == null && emailUser != null) {
				if (emailUser.getId() == idUser) {
					return true;
				} else {
					return false;
				}
			}
			if (nameUser == null && emailUser == null) {
				return true;
			}

			if (nameUser != null && emailUser != null) {
				if (nameUser.getId() == idUser && emailUser.getId() == idUser) {
					return true;
				} else {

					return false;
				}

			} else {
				return false;
			}

		}
	}

	public void sendMail(String to, String subject, String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailSender.send(mailMessage);
	}

	@Override
	public List<UserModel> getAll() {
		List<UserEntity> entities = userRepository.findAll();
		List<UserModel> list = new ArrayList<>();
		for (UserEntity items: entities) {
			if(!items.getUserName().equals(SecurityUtils.getPrincipal().getUsername())) {
				list.add(converterUser.convertToDto(items));
			}
		}
		return list;
	}

}
