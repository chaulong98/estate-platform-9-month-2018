package com.estate.controller.rest;

import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	@Autowired
	private IBuildingService buildingService;

	@PostMapping
	public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO newBuilding) {
		return ResponseEntity.ok(buildingService.save(newBuilding.getId(), newBuilding));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable("id") long id, @RequestBody BuildingDTO updateBuilding) {
		return ResponseEntity.ok(buildingService.save(id, updateBuilding));
	}

	@PostMapping("/{id}/users")
	public ResponseEntity<Void> assignUserToBuilding(@PathVariable("id") long id, @RequestBody long[] users) {
		buildingService.assignUserToBuilding(users, id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/priority")
	public ResponseEntity<Void> updateBuildingPriority(@PathVariable("id") long id, @RequestParam(value = "action", required = false) String action) {
		buildingService.updatePriority(action, id);
		return ResponseEntity.noContent().build();
	}
}
