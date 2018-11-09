package com.example.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.BuildingModel;
import com.example.repository.BuildingRepository;
import com.example.service.BuildingService;
import com.example.service.DistrictService;
import com.example.service.UserService;
import com.example.utils.DisplayTagUtils;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private UserService userService;
    @Autowired DistrictService districtService;
	@RequestMapping(value = "/manager/building/list", method = RequestMethod.GET)
	public String listBuilding(ModelMap map, @ModelAttribute("model") BuildingModel model, HttpServletRequest request) {
		DisplayTagUtils.initSearchBean(request, model);
		Pageable pageable = new PageRequest(model.getPage() - 1, model.getMaxPageItems());
		List<BuildingModel> buildingModels = buildingService.getAllBuilding(pageable);
		model.setListResult(buildingModels);
		model.setTotalItems((int) buildingRepository.count());
		map.addAttribute("model", model);
		return "admin/building/list";
	}

	@RequestMapping(value = "/manager/building/edit", method = RequestMethod.GET)
	public String editBuilding(ModelMap map) {
		BuildingModel model = new BuildingModel();
		model.setListuser(userService.getAll());
		model.setMapDistrict(districtService.getAllDictrict());
		map.addAttribute("model", model);
		return "admin/building/edit";
	}
	
	@RequestMapping(value = "/manager/building/{idBuilding}", method = RequestMethod.GET)
	public String editBuilding(ModelMap map,@PathVariable("idBuilding") Long id) {
		BuildingModel model = buildingService.findBuilding(id);
		model.setMapDistrict(districtService.getAllDictrict());
		model.setListuser(userService.getAll());
		map.addAttribute("model", model);
		return "admin/building/edit";
	}

}
