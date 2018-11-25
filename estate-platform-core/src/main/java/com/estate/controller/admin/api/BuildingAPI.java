package com.estate.controller.admin.api;

import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/building")
public class BuildingAPI {

    @Autowired
    private IBuildingService iBuildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(iBuildingService.save(buildingDTO));
    }

    @PutMapping
    public ResponseEntity<BuildingDTO> updateBuilding(@RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(iBuildingService.update(buildingDTO));
    }
}
