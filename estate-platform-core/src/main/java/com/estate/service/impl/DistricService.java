package com.estate.service.impl;

import com.estate.repository.DistricRepository;
import com.estate.service.IDistricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistricService implements IDistricService {

    @Autowired
    private DistricRepository districRepository;

    @Override
    public Map<String, String> getDistrics() {
        Map<String, String> results = new HashMap<>();
        districRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }
}
