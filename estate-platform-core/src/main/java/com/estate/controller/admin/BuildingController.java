package com.estate.controller.admin;

import com.estate.constant.SystemConstant;
import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import com.estate.service.IDistrictService;
import com.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/admin/building/list", method = RequestMethod.GET)
    public ModelAndView showBuilding(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    //giao phó tòa nhà
    @RequestMapping(value = "/admin/building/entrust", method = RequestMethod.GET)
    public ModelAndView showBuildingAssignment(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/entrust");
        mav.addObject("listUser", userService.getUsers());
        return mav;
    }


    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editNews(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                 @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
       ModelAndView mav = new ModelAndView("admin/building/edit");
        if (id != null) {
            model = buildingService.findOneId(id);
        }
        mav.addObject("districts", districtService.getDistricts());
        mav.addObject("buildingTypes", buildingService.getBuildingType());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

}
