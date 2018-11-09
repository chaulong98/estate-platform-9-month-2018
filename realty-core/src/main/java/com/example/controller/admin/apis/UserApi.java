package com.example.controller.admin.apis;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.UserModel;
import com.example.service.UserService;
import com.example.utils.SessionUtils;

@RestController
@RequestMapping(value = "/ajax/user")
public class UserApi {

	@Autowired 
	private UserService userService;
	@PostMapping
	public ResponseEntity<UserModel> insertUser(@RequestBody UserModel userModel,HttpSession session) {
		SessionUtils.getSession().putValue(session, "messageResponse", "Thành Công");
		return ResponseEntity.ok(userService.insertUser(userModel));
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserModel> editUser(@PathVariable("id") Long id ,@RequestBody UserModel userModel,HttpSession session) {
		SessionUtils.getSession().putValue(session, "messageResponse", "Thành Công");
		return ResponseEntity.ok(userService.updateUser(id, userModel));
	}
//	@PostMapping
//	@ResponseBody
//	public UserModel insertUser(@RequestBody UserModel userModel,HttpSession session) {
//		SessionUtils.getSession().putValue(session, "messageResponse", "Thành Công");
//		return userService.insertUser(userModel);
//	}
	
}
