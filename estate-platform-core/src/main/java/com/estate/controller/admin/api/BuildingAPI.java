package com.estate.controller.admin.api;

import com.estate.dto.BuildingDTO;
import com.estate.dto.MyUserDetail;
import com.estate.security.utils.SecurityUtils;
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
    public ResponseEntity<BuildingDTO> createNew(@RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(iBuildingService.save(buildingDTO));
    }

    @PutMapping
    public ResponseEntity<BuildingDTO> updateNew(@RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(iBuildingService.update(buildingDTO));
    }


    @PostMapping(path = "/assignment")
    public ResponseEntity<Void> assignStaff(@RequestBody long[] userID, @RequestParam long buildingId) {
        iBuildingService.assignStaff(userID, buildingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/staffs")
    public ResponseEntity<Object> getListUserIdByBuilding(@RequestParam long buildingId) {
        return ResponseEntity.ok(iBuildingService.getStaffBuilding(buildingId));
    }

    @PostMapping(path = "/priority")
    public ResponseEntity<Void> addBuildingToPriority(@RequestParam long buildingId) {
        iBuildingService.addBuildingToPriority(buildingId);
        return ResponseEntity.noContent().build();
    }
}
