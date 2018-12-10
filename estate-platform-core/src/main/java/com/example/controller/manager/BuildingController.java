package com.example.controller.manager;

import com.example.constant.SystemConstant;
import com.example.dto.BuildingDTO;
import com.example.dto.DistrictDTO;
import com.example.dto.UserDTO;
import com.example.enums.BuildingType;
import com.example.service.IBuildingService;
import com.example.service.IDistrictService;
import com.example.service.IUserService;
import com.example.service.impl.BuildingService;
import com.example.service.impl.UserService;
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
import java.util.TreeMap;

@Controller
public class BuildingController {

    @Autowired
    IBuildingService buildingService;

    @Autowired
    IUserService userService;

    @Autowired
    IDistrictService districtService;

    @RequestMapping(value = "/admin/building/list", method = RequestMethod.GET)
    public ModelAndView listPage(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model){
        ModelAndView mav = new ModelAndView("manager/building/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editPage(BuildingDTO model, @RequestParam(value = "id", required = false) Long id){
        ModelAndView mav = new ModelAndView("manager/building/edit");
        if(id != null){
            model = buildingService.findById(id);
        }
        Map<String, String> mapDistrict = new HashMap<>();
        Map<String, String> mapType = new HashMap<>();
        buildMapDistrict(mapDistrict);
        buildMapType(mapType);
        mav.addObject(SystemConstant.MODEL, model);
        mav.addObject(SystemConstant.MAP_DISTRICT, mapDistrict);
        mav.addObject(SystemConstant.TYPE, mapType);
        return mav;
    }



    @RequestMapping(value = "/ajax-manager-building-delivery", method = RequestMethod.GET)
    public ModelAndView staffPage(UserDTO model, @RequestParam(value = "id", required = false) Long buildingId){
        ModelAndView mav = new ModelAndView("manager/building/delivery");
        model.setListResult(buildingService.getStaff(SystemConstant.USER_ROLE, buildingId));
        mav.addObject(SystemConstant.MODEL, model);
        mav.addObject("buildingId", buildingId);
        return mav;
    }

    private void buildMapDistrict(Map<String, String> mapDistrict) {
        List<DistrictDTO> districts = districtService.findAll();
        for(DistrictDTO dto : districts){
            mapDistrict.put(dto.getCode(), dto.getName());
        }
    }

    private void buildMapType(Map<String, String> mapType) {
        for(BuildingType type : BuildingType.values()){
            mapType.put(type.toString(), type.getName());
        }
    }
}
