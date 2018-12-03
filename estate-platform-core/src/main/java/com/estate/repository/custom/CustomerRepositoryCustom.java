package com.estate.repository.custom;


import com.estate.entity.CustomerEntity;
import com.estate.repository.paging.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerRepositoryCustom {
    List<CustomerEntity> findAll(Map<String, Object> properties, Pageable pageable);
    Long getTotalItems(Map<String, Object> properties);
    String getPermission(String userName, String pass);
}