package com.example.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfUser")
public class HomeController {

    @RequestMapping(value = "/user-home", method = RequestMethod.GET)
    public ModelAndView userHome(){
        ModelAndView mav = new ModelAndView("user/web");
        return mav;
    }
}
