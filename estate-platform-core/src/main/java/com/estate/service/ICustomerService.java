package com.estate.service;

import com.estate.dto.CustomerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void findAll(CustomerDTO model, Pageable pageable);
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO updateCustomer);
    CustomerDTO findById(long id);
    void assignStaff(long[] userID, long customerId);
    List<Long> getStaffCustomer(long customerId);
}
