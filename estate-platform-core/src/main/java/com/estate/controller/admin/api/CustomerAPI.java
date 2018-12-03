package com.estate.controller.admin.api;

import com.estate.dto.BuildingDTO;
import com.estate.dto.CustomerDTO;
import com.estate.service.IBuildingService;
import com.estate.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/customer")
public class CustomerAPI {

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(iCustomerService.save(customerDTO));
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(iCustomerService.update(customerDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@RequestBody long[] id) {
        iCustomerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
