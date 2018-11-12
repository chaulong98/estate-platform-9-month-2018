package com.estate.controller.admin;

import com.estate.constant.SystemConstant;
import com.estate.dto.BuildingDTO;
import com.estate.security.utils.MessageResponseUtils;
import com.estate.service.IBuildingService;
import com.estate.service.IDistrictService;
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
import java.util.Map;


@Controller
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IDistrictService districtService;

    @RequestMapping(value = "/admin/building/list", method = RequestMethod.GET)
    public ModelAndView showBuilding (@ModelAttribute("model") BuildingDTO model) {
        ModelAndView mav = new ModelAndView("/admin/building/list");
        buildingService.findAll(model, new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
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
