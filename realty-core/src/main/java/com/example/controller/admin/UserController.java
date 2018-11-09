package com.example.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.constant.SystemConstant;
import com.example.model.UserModel;
import com.example.service.RoleService;
import com.example.service.UserService;
import com.example.utils.DisplayTagUtils;

@Controller(value = "userController")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserModel model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/list");
		DisplayTagUtils.initSearchBean(request, model);
//		phan tu bat dau va tong so item tren 1 trang
		Pageable pageable = new PageRequest(model.getPage() - 1, model.getMaxPageItems());
		List<UserModel> users = userService.getNews(model.getUserName(), model.getUserName(), pageable);
		model.setListResult(users);
		model.setTotalItems((int) userService.getTotalItems(model.getUserName(), model.getUserName()));
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}
	
	@RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
	public ModelAndView redirectInsertPage() {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserModel user = new UserModel();
		user.setMapRole(roleService.getRoles());
		mav.addObject(SystemConstant.MODEL, user);
		return mav;
	}
	@RequestMapping(value = "/admin/user/{id}", method = RequestMethod.GET)
	public ModelAndView redirectEditPage(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserModel model = userService.findUserById(id);
		model.setMapRole(roleService.getRoles());
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}
}
