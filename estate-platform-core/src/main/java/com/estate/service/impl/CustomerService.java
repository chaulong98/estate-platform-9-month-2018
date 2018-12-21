package com.estate.service.impl;

import com.estate.converter.CustomerConverter;
import com.estate.dto.AbstractDTO;
import com.estate.dto.CustomerDTO;
import com.estate.entity.BaseEntity;
import com.estate.entity.CustomerEntity;
import com.estate.entity.UserEntity;
import com.estate.repository.CustomerRepository;
import com.estate.repository.UserRepository;
import com.estate.repository.custom.CustomCustomerRepository;
import com.estate.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter converter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomCustomerRepository customCustomerRepository;

    public void findAll(CustomerDTO model, Pageable pageable) {
        List<CustomerEntity> customers = customerRepository.findAll(pageable).getContent();
        List<CustomerDTO> customerDTOS = customers.stream().map(item -> converter.convertToDto(item)).collect(Collectors.toList());
        model.setListResult(customerDTOS);
        model.getListResult().sort(Comparator.comparing(AbstractDTO::getId));
        model.setTotalItems(customCustomerRepository.getTotalItems().intValue());
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = converter.convertToEntity(customerDTO);
        customerRepository.save(customerEntity);
        return converter.convertToDto(customerEntity);
    }

    @Override
    @Transactional
    public CustomerDTO update(CustomerDTO updateCustomer) {
        CustomerEntity existCustomer = customerRepository.findOne(updateCustomer.getId());
        CustomerEntity update = converter.convertToEntity(updateCustomer);
        update.setCreatedDate(existCustomer.getCreatedDate());
        update.setCreatedBy(existCustomer.getCreatedBy());
        existCustomer = customerRepository.save(update);
        return converter.convertToDto(existCustomer);
    }

    @Override
    public CustomerDTO findById(long id) {
        CustomerEntity customerEntity = customerRepository.findOne(id);
        return converter.convertToDto(customerEntity);
    }

    @Override
    @Transactional
    public void assignStaff(long[] userID, long customerId) {
        CustomerEntity customerEntity = customerRepository.findOneById(customerId);
        List<UserEntity> list = Arrays.stream(userID).mapToObj(id -> userRepository.findOneById(id)).collect(Collectors.toList());
        customerEntity.setStaffCustomers(list);
        customerRepository.save(customerEntity);
    }

    @Override
    public List<Long> getStaffCustomer(long customerId) {
        CustomerEntity customerEntity = customerRepository.findOne(customerId);
        return customerEntity.getStaffCustomers().stream().map(BaseEntity::getId).collect(Collectors.toList());
    }
}
