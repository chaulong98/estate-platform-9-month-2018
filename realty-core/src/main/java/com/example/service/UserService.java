package com.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.entity.UserEntity;
import com.example.model.UserModel;

public interface UserService {

	List<UserModel> getNews(String userName,String fullName,Pageable pageable);
	long getTotalItems(String userName,String fullName);
	UserModel insertUser(UserModel model);
	UserModel updateUser(Long id, UserModel model);
	UserModel findUserById(Long id);
	Boolean checkUserNameAndEmailUnique(String userName , String email,Long idUser);
	List<UserModel> getAll();
	List<UserModel> getUserAdmin();
	
	
}
