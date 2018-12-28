package com.estate.controller.admin;

import com.estate.constant.SystemConstant;
import com.estate.converter.BuildingConverter;
import com.estate.dto.BuildingDTO;
import com.estate.dto.UserDTO;
import com.estate.entity.BuildingEntity;
import com.estate.enums.BuildingType;
import com.estate.security.utils.MessageResponseUtils;
import com.estate.security.utils.SecurityUtils;
import com.estate.service.IBuildingService;
import com.estate.service.IDistrictService;
import com.estate.service.IUserService;
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
import java.util.*;


@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/admin/building/list", "/admin/building/assignment"}, method = RequestMethod.GET)
    public ModelAndView showBuilding (@ModelAttribute("model") BuildingDTO model, UserDTO staff,
                                      @RequestParam(value = "id",required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        initMessageResponse(mav,request);
        userService.findAll(staff,new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        mav.addObject("staff",staff);
        mav.addObject("district", districtService.getDistrict());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/building/list-priority-building", method = RequestMethod.GET)
    public ModelAndView showPriorityBuilding (@ModelAttribute("model") BuildingDTO model, UserDTO staff,
                                      @RequestParam(value = "id",required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/list-priority-building");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        initMessageResponse(mav,request);
        userService.findAll(staff,new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        mav.addObject("staff",staff);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editBuilding(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                 @RequestParam(value = "id",required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        if(id!=null){
            model = buildingService.findById(id);
        }
        initMessageResponse(mav,request);
        ArrayList<String> types = new ArrayList<>();
        EnumSet.allOf(BuildingType.class).forEach(buildingType -> types.add(buildingType.getValue()));
        mav.addObject("type", types);
        mav.addObject("district", districtService.getDistrict());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if(StringUtils.isNotBlank(message)){
            Map<String, String> messageResponse = MessageResponseUtils.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageResponse.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE,messageResponse.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }
}
