package com.agh.controller;

import com.agh.model.Suppliers;
import com.agh.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuppliersController {

    private final SuppliersService suppliersService;

    @Autowired
    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @GetMapping("suppliers")
    public ResponseEntity<List<Suppliers>> getAll() {
        return new ResponseEntity<>(suppliersService.getAll(), HttpStatus.OK);
    }
}
