package com.estate.repository;

import com.estate.entity.CustomerEntity;
import com.estate.repository.custom.CustomerRepositoryCustom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomerRepositoryCustom {
    Page<CustomerEntity> findAll(Pageable pageable);


}
