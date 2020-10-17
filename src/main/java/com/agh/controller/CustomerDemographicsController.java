package com.agh.controller;

import com.agh.model.CustomerDemographics;
import com.agh.service.CustomerDemographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerDemographicsController {

    private final CustomerDemographicsService customerDemographicsService;

    @Autowired
    public CustomerDemographicsController(CustomerDemographicsService customerDemographicsService) {
        this.customerDemographicsService = customerDemographicsService;
    }


    @GetMapping("customerDemographics")
    public ResponseEntity<List<CustomerDemographics>> getAll() {
        return new ResponseEntity<>(customerDemographicsService.getAll(), HttpStatus.OK);
    }
}
