package com.example.controller.user;

import com.example.constant.SystemConstant;
import com.example.dto.BuildingDTO;
import com.example.dto.DistrictDTO;
import com.example.dto.UserDTO;
import com.example.enums.BuildingType;
import com.example.service.IBuildingService;
import com.example.service.IDistrictService;
import com.example.service.IUserService;
import com.example.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "buildingControllerOfWeb")
public class BuildingController {

    @Autowired
    IBuildingService buildingService;

    @Autowired
    IUserService userService;

    @Autowired
    IDistrictService districtService;

    @RequestMapping(value = "/building/list", method = RequestMethod.GET)
    public ModelAndView listPage(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model){
        ModelAndView mav = new ModelAndView("user/building/list");
        buildingService.findAssinedBuilding(model, SecurityUtils.getPrincipal().getId(), new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/building/list/priority", method = RequestMethod.GET)
    public ModelAndView showPriorityList(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model){
        ModelAndView mav = new ModelAndView("user/building/priority_list");
        buildingService.findPriorityBuilding(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }
}
