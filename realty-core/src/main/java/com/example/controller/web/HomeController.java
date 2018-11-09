package com.example.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public String Home(ModelMap map) {
		
		return "web/home";
	}
	@RequestMapping(value = "/login/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDenied() {
		return "redirect:/login/dang-nhap?accessDenied";
	}
}
