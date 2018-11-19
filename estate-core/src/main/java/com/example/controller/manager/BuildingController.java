package com.example.controller.manager;

import com.example.constant.SystemConstant;
import com.example.dto.BuildingDTO;
import com.example.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @RequestMapping(value = "/manager-building-list", method = RequestMethod.GET)
    public ModelAndView managerHome(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model){
        ModelAndView mav = new ModelAndView("manager/product/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(model);
        return mav;
    }
}
