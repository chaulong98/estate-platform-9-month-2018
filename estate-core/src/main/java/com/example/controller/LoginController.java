package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String defaultServlet(){
        return "redirect:/dang-nhap";
    }

    @RequestMapping("/dang-nhap")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
}
