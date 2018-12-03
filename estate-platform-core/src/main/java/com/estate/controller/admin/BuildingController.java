package com.estate.controller.admin;

import com.estate.constant.SystemConstant;
import com.estate.dto.BuildingDTO;

import com.estate.service.IBuildingService;
import com.estate.service.IDistrictService;
import com.estate.service.IUserService;
import com.estate.utils.MessageResponseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
import com.estate.repository.paging.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BuildingController {

    @Autowired
    private IBuildingService iBuildingService;

    @Autowired
    private IDistrictService iDistrictService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = {"/admin/building/list"}, method = RequestMethod.GET)

    public ModelAndView showBuildings(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        /*custom JPA*/

        iBuildingService.findAll(model,new com.estate.repository.paging.PageRequest(model.getPage(), model.getMaxPageItems()));
        /*spring data jpa*/
        /*newService.findAll(model, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));*/
        mav.addObject("users", iUserService.findStaffs());
        mav.addObject("districts", iDistrictService.getDistricts());
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }



    @RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
    public ModelAndView editNew(@ModelAttribute(SystemConstant.MODEL) BuildingDTO model,
                                @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        if (id != null) {
            model = iBuildingService.findById(id);
        }
        initMessageResponse(mav, request);
        mav.addObject("districts", iDistrictService.getDistricts());
        mav.addObject("types", iBuildingService.getBuildingTypes());
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
