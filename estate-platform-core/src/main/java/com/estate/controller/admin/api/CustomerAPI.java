package com.estate.controller.admin.api;

import com.estate.dto.CustomerDTO;
import com.estate.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/customer")
public class CustomerAPI {
    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createNew(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateNew(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.update(customerDTO));
    }


    @PostMapping(path = "/assignment")
    public ResponseEntity<Void> assignStaff(@RequestBody long[] userID, @RequestParam long customerID) {
        customerService.assignStaff(userID, customerID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/staffs")
    public ResponseEntity<Object> getListStaffIdByCustomer(@RequestParam long customerID) {
        return ResponseEntity.ok(customerService.getStaffCustomer(customerID));
    }
}
