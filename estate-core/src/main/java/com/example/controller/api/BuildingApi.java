package com.example.controller.api;

import com.example.dto.BuildingDTO;
import com.example.dto.UserDTO;
import com.example.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuildingApi {

    @Autowired
    BuildingService buildingService;

    @RequestMapping(value = "/api/building", method = RequestMethod.POST)
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO buildingDTO){
        return  ResponseEntity.ok(buildingService.save(buildingDTO));
    }

    @RequestMapping(value = "/api/building", method = RequestMethod.PUT)
    public ResponseEntity<BuildingDTO> updateBuilding(@RequestBody BuildingDTO buildingDTO){
            return  ResponseEntity.ok(buildingService.update(buildingDTO));
    }

    @RequestMapping(value = "/api/building/{id}/assignment", method = RequestMethod.POST)
    public ResponseEntity<BuildingDTO> assignBuilding(@RequestBody long[] staffIds, @PathVariable("id") Long buildingId){
        return ResponseEntity.ok(buildingService.assignBuilding(staffIds, buildingId));
    }
}
