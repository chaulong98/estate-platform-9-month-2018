package com.example.controller.admin.apis;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BuildingModel;
import com.example.model.UserModel;
import com.example.service.BuildingService;
import com.example.utils.SessionUtils;

@RestController
@RequestMapping(value = "/ajax/building")
public class BuildingApi {

	@Autowired 
	private BuildingService buildingService;
	@PostMapping
	public ResponseEntity<BuildingModel> insertBuiding(@RequestBody BuildingModel buildingModel,HttpSession session) {
		SessionUtils.getSession().putValue(session, "messageResponse", "Thành Công");
		return ResponseEntity.ok(buildingService.insertBuilding(buildingModel));
	}
	@PutMapping("/{id}")
	public ResponseEntity<BuildingModel> editBuilding(@PathVariable("id") Long id ,@RequestBody BuildingModel  model,HttpSession session) {
		SessionUtils.getSession().putValue(session, "messageResponse", "Thành Công");
		return ResponseEntity.ok(buildingService.updateBuilding(id, model));
	}
	@PostMapping("/manager/{id}")
	public ResponseEntity<BuildingModel> addManager(@PathVariable("id") Long id,@RequestBody BuildingModel buildingModel,HttpSession session) {
		SessionUtils.getSession().putValue(session, "messageResponse", "Thành Công");
	
		return ResponseEntity.ok(buildingService.editManager(id, buildingModel));
	}
	@DeleteMapping
	public ResponseEntity<Void> deleteNews(@RequestBody long[] ids) {
		buildingService.deleteUserBuilding(ids);
		return ResponseEntity.noContent().build();
	}
}
