package com.example.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@RequestMapping(value = "/manager/home", method = RequestMethod.GET)
	public String HomePage(ModelMap map) {
		return "admin/home";
	}
}
