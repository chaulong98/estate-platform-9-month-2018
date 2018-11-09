package com.estate.controller.admin;

import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import com.estate.service.IDistricService;
import com.estate.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistricService districService;

    @RequestMapping(value = "/admin/building/list", method = RequestMethod.GET)
    public ModelAndView showBuilding(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/building/assignment", method = RequestMethod.GET)
    public ModelAndView showBuildingAssignment(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        return mav;
    }


    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editNews(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                 @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
       ModelAndView mav = new ModelAndView("admin/building/edit");
        if (id != null) {
            model = buildingService.findOneId(id);
        }
        mav.addObject("districs", districService.getDistrics());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

}
