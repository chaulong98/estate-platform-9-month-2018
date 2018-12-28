package com.example.controller.manager;

import com.example.constant.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfManager")
public class HomeController {

    @RequestMapping(value = SystemConstant.MANAGER_HOME, method = RequestMethod.GET)
    public ModelAndView managerHome(){
        ModelAndView mav = new ModelAndView("manager/web");
        return mav;
    }
}
