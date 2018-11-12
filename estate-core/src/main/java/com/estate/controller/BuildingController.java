package com.estate.controller;

import com.estate.dto.BuildingDTO;
import com.estate.page.PageRequest;
import com.estate.security.util.SecurityUtils;
import com.estate.service.IBuildingService;
import com.estate.service.IUserService;
import com.estate.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BuildingController {
	@Autowired
	private IBuildingService buildingService;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = {"/admin/building/list","/admin/building/assignment"}, method = RequestMethod.GET)
	public ModelAndView showBuilding(@ModelAttribute("model") BuildingDTO model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		DisplayTagUtils.initSearchBean(request, model);
		model.setLink(request.getServletPath());
		List<BuildingDTO> news = buildingService.findAll(model);
		model.setListResult(news);
		model.setTotalItems(buildingService.getTotalItems(model));
		mav.addObject("mapTypes", buildingService.getBuildingTypes());
		mav.addObject("urlMapping", request.getServletPath());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/building/edit", method = RequestMethod.GET)
	public ModelAndView addOrUpdateBuildingPage(@ModelAttribute("model") BuildingDTO model,
	                                            @RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		if (id != null) {
			model = buildingService.findById(id);
		}
		mav.addObject("mdoel", model);
		mav.addObject("mapTypes", buildingService.getBuildingTypes());
		return mav;
	}

	@RequestMapping(value = "/admin/building/priority/list", method = RequestMethod.GET)
	public ModelAndView showBuildingPriority(@ModelAttribute("model") BuildingDTO model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/building/priority/list");
		DisplayTagUtils.initSearchBean(request, model);
		long userId = SecurityUtils.getPrincipal().getId();
		List<BuildingDTO> buildings = buildingService.findAllPriorities(userId, new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
		model.setListResult(buildings);
		model.setTotalItems(buildingService.getTotalItemPriorities(userId));
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/admin/building/{id}/view", method = RequestMethod.GET)
	public ModelAndView addOrUpdateBuildingPage(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("admin/building/detail");
		BuildingDTO model = buildingService.findById(id);
		mav.addObject("model", model);
		mav.addObject("mapTypes", buildingService.getBuildingTypes());
		return mav;
	}

}
