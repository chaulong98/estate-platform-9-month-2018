package com.example.controller.user;

import com.example.constant.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    @RequestMapping(value = SystemConstant.USER_HOME, method = RequestMethod.GET)
    public ModelAndView userHome(){
        ModelAndView mav = new ModelAndView("user/web");
        return mav;
    }
}
