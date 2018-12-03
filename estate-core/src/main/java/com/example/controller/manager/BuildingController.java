package com.example.controller.manager;

import com.example.constant.SystemConstant;
import com.example.dto.BuildingDTO;
import com.example.dto.UserDTO;
import com.example.enums.BuildingType;
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
import java.util.Map;
import java.util.TreeMap;

@Controller
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/manager-building-list", method = RequestMethod.GET)
    public ModelAndView listPage(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model){
        ModelAndView mav = new ModelAndView("manager/building/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/manager-building-edit", method = RequestMethod.GET)
    public ModelAndView editPage(BuildingDTO model, @RequestParam(value = "id", required = false) Long id){
        ModelAndView mav = new ModelAndView("manager/building/edit");
        if(id != null){
            model = buildingService.findById(id);
        }
        Map<Integer, String> mapDistrict = new TreeMap<>();
        Map<String, String> mapType = new TreeMap<>();
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


    private void buildMapDistrict(Map<Integer, String> mapDistrict) {
        mapDistrict.put(1, "Quận 1");
        mapDistrict.put(2, "Quận 2");
        mapDistrict.put(3, "Quận 3");
        mapDistrict.put(4, "Quận 4");
        mapDistrict.put(5, "Quận 5");
        mapDistrict.put(6, "Quận 6");
        mapDistrict.put(7, "Quận 7");
        mapDistrict.put(8, "Quận 8");
        mapDistrict.put(9, "Quận 9");
        mapDistrict.put(10, "Quận 10");
        mapDistrict.put(11, "Quận 11");
        mapDistrict.put(12, "Quận 12");
        mapDistrict.put(13, "Quận Bình Thạnh");
    }

    private void buildMapType(Map<String, String> mapType) {
        for(BuildingType type : BuildingType.values()){
            mapType.put(type.toString(), type.getName());
        }
    }
}
