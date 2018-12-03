package com.estate.service.impl;


import com.estate.converter.CustomerConverter;
import com.estate.dto.CustomerDTO;
import com.estate.entity.CustomerEntity;
import com.estate.repository.CustomerRepository;
import com.estate.repository.paging.Pageable;
import com.estate.service.ICustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.springframework.data.domain.Pageable;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public void findAll(CustomerDTO model, Pageable pageable) {
        /*Custom JPA*/
        Map<String, Object> properties = buildNewProperties(model);
        List<CustomerEntity> news = customerRepository.findAll(properties, pageable);
        model.setListResult(news.stream().map(item -> customerConverter.convertToDto(item)).collect(Collectors.toList()));
        model.setTotalItems(customerRepository.getTotalItems(properties).intValue());

    }

    private Map<String,Object> buildNewProperties(CustomerDTO model) {
        Map<String, Object> results = new HashMap<>();
        return results;
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.convertToEntity(customerDTO);
        customerEntity = customerRepository.save(customerEntity);
        return customerConverter.convertToDto(customerEntity);
    }

    @Override
    @Transactional
    public CustomerDTO update(CustomerDTO updateNew) {
        CustomerEntity existNew = customerRepository.findOne(updateNew.getId());
        CustomerEntity updateNewEntity = customerConverter.convertToEntity(updateNew);

        updateNewEntity.setCreatedDate(existNew.getCreatedDate());
        updateNewEntity.setCreatedBy(existNew.getCreatedBy());
        existNew = customerRepository.save(updateNewEntity);
        return customerConverter.convertToDto(existNew);
    }

    @Override
    public CustomerDTO findById(long id) {
        CustomerEntity newEntity = customerRepository.findOne(id);
        return customerConverter.convertToDto(newEntity);
    }


    @Override
    @Transactional
    public void deleteCustomer(long[] id) {
        for (long item : id) {
            customerRepository.delete(item);
        }
    }
}
