package com.estate.controller.admin;

import com.estate.constant.SystemConstant;
import com.estate.dto.CustomerDTO;
import com.estate.dto.UserDTO;
import com.estate.security.utils.MessageResponseUtils;
import com.estate.service.ICustomerService;
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
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/customer/list", method = RequestMethod.GET)
    public ModelAndView showCustomers (@ModelAttribute("model") CustomerDTO model, UserDTO staff,
                                      @RequestParam(value = "id",required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        customerService.findAll(model, new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        initMessageResponse(mav,request);
        userService.findAll(staff,new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        mav.addObject("staff",staff);
        mav.addObject(SystemConstant.MODEL, model);
        return mav;
    }

    @RequestMapping(value = "/admin/customer/edit", method = RequestMethod.GET)
    public ModelAndView editCustomer(@ModelAttribute(SystemConstant.MODEL) CustomerDTO model,
                                     @RequestParam(value = "id",required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        customerService.findAll(model, new PageRequest(model.getPage() - 1 , model.getMaxPageItems()));
        if(id!=null){
            model = customerService.findById(id);
        }
        initMessageResponse(mav,request);
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
