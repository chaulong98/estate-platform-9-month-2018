package com.estate.service;



//import org.springframework.data.domain.Pageable;

import com.estate.dto.CustomerDTO;
import com.estate.repository.paging.Pageable;

public interface ICustomerService {
    void findAll(CustomerDTO model, Pageable pageable);
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO updateCustomer);
    CustomerDTO findById(long id);
    void deleteCustomer(long[] id);
}
