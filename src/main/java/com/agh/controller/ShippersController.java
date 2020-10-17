package com.agh.controller;

import com.agh.model.Shippers;
import com.agh.service.ShippersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShippersController {

    private final ShippersService shippersService;

    @Autowired
    public ShippersController(ShippersService shippersService) {
        this.shippersService = shippersService;
    }

    @GetMapping("shippers")
    public ResponseEntity<List<Shippers>> getAll() {
        return new ResponseEntity<>(shippersService.getAll(), HttpStatus.OK);
    }
}
