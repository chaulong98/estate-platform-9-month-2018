package com.estate.controller.admin;


import com.estate.constant.SystemConstant;
import com.estate.dto.CustomerDTO;
import com.estate.repository.paging.PageRequest;
import com.estate.service.ICustomerService;
import com.estate.service.IRoleService;
import com.estate.service.IUserService;
import com.estate.utils.MessageResponseUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//import org.springframework.data.domain.PageRequest;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/admin/customer/list", method = RequestMethod.GET)
    public ModelAndView showNews(@ModelAttribute(SystemConstant.MODEL) CustomerDTO model) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        /*custom JPA*/
        iCustomerService.findAll(model, new PageRequest(model.getPage(), model.getMaxPageItems()));
        String permission = iRoleService.getRoles();
        mav.addObject("users", iUserService.findStaffs());
        mav.addObject("permission",permission);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/customer/edit", method = RequestMethod.GET)
    public ModelAndView editNew(@ModelAttribute(SystemConstant.MODEL) CustomerDTO model,
                                @RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        if (id != null) {
            model = iCustomerService.findById(id);
        }
        initMessageResponse(mav, request);
        String permission = iRoleService.getRoles();
        mav.addObject("permission",permission);
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
