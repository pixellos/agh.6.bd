package com.agh.controller;

import com.agh.model.Orders;
import com.agh.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("orders")
    public ResponseEntity<List<Orders>> getAll() {
        return new ResponseEntity<>(ordersService.getAll(), HttpStatus.OK);
    }
}
