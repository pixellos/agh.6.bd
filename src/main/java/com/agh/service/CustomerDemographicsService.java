package com.agh.service;

import com.agh.model.CustomerDemographics;
import com.agh.repository.CustomerDemographicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDemographicsService {

    private final CustomerDemographicsRepository customerDemographicsRepository;

    @Autowired
    public CustomerDemographicsService(CustomerDemographicsRepository customerDemographicsRepository) {
        this.customerDemographicsRepository = customerDemographicsRepository;
    }

    public List<CustomerDemographics> getAll() {
        return customerDemographicsRepository.getAll();
    }
}
