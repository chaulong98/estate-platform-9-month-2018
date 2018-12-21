package com.estate.controller.admin;

import com.estate.constant.SystemConstant;
import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import com.estate.service.IDistrictService;
import com.estate.service.IUserService;
import com.estate.utils.MessageResponseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IUserService userService;
    public static Long id;


    @RequestMapping(value = {"/admin/building/list","/admin/building/assignment"}, method = RequestMethod.GET)
    public ModelAndView showBuilding(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                        HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        model.setUrlMapping(request.getServletPath());
        List<BuildingDTO> buildings = buildingService.findAll(model, new com.estate.paging.PageRequest(model.getPage(), model.getMaxPageItems()));
        model.setListResult(buildings);
        model.setTotalItem(buildingService.getTotalItems(model));
        mav.addObject(SystemConstant.MODEL, model);
        mav.addObject("districts", districtService.getDistricts());
        mav.addObject("buildingTypes", buildingService.getBuildingType());
        mav.addObject("staffMaps", userService.getStaffs());
//        mav.addObject("modal1", model1);
        mav.addObject("listUser", userService.getUsers(model.getId()));
        initMessageResponse(mav, request);
        return mav;
    }

    //hien building dc giao pho o user
    @RequestMapping(value = "/admin/building/assignment/list", method = RequestMethod.GET)
    public ModelAndView showBuildings(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        buildingService.findBuildingByUsers(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        mav.addObject("districts", districtService.getDistricts());
        mav.addObject("buildingTypes", buildingService.getBuildingType());
        return mav;
    }

    //hien danh sach nha uu tien
    @RequestMapping(value = "/admin/building/priority", method = RequestMethod.GET)
    public ModelAndView showBuildingPriority(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/priority");
        buildingService.findBuildingPriority(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }


    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editNews(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                 @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        if (id != null) {
            model = buildingService.findOneId(id);
        }
        initMessageResponse(mav, request);
        mav.addObject("districts", districtService.getDistricts());
        mav.addObject("buildingTypes", buildingService.getBuildingType());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (StringUtils.isNotBlank(message)) {
            Map<String, String> messageResponse = MessageResponseUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageResponse.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageResponse.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }

}
