package com.estate.controller.admin.api;

import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/building")
public class BuildingAPI {

    @Autowired
    private IBuildingService buildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO dto) {
        return ResponseEntity.ok(buildingService.save(dto));
    }

    @PutMapping
    public ResponseEntity<BuildingDTO> updateBuilding(@RequestBody BuildingDTO updateBuilding) {
        return ResponseEntity.ok(buildingService.update(updateBuilding));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBuilding(@RequestBody long[] id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.noContent().build();
    }

//    //        lưu nhân viên dc phụ trách
    @PostMapping("/{id}")
    public ResponseEntity<Void> assignStaffToBuilding(@PathVariable("id") Long buildingId, @RequestBody long[] userIds) {
        buildingService.assignStaffsToBuilding(buildingId, userIds);
        return ResponseEntity.noContent().build();
    }

}
