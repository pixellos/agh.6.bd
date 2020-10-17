package com.agh.controller;

import com.agh.model.Customers;
import com.agh.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {

    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("customers")
    public ResponseEntity<List<Customers>> getAll() {
        return new ResponseEntity<>(customersService.getAll(), HttpStatus.OK);
    }
}
