package com.agh.controller;

import com.agh.model.Orders;
import com.agh.request.CreateOrderRequest;
import com.agh.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("orders/customer/{customerId}")
    public ResponseEntity<List<Orders>> getAllByCustomerId(@PathVariable String customerId) {
        return new ResponseEntity<>(ordersService.getAllByCustomerId(customerId), HttpStatus.OK);
    }

    @GetMapping("orders/employee/{employeeId}")
    public ResponseEntity<List<Orders>> getAllByEmployeeId(@PathVariable Short employeeId) {
        return new ResponseEntity<>(ordersService.getAllByEmployeeId(employeeId), HttpStatus.OK);
    }

    @GetMapping("orders/shipper/{shipperId}")
    public ResponseEntity<List<Orders>> getAllByShipperId(@PathVariable Short shipperId) {
        return new ResponseEntity<>(ordersService.getAllByShipperId(shipperId), HttpStatus.OK);
    }

    @PostMapping("orders")
    public ResponseEntity<Void> create(@RequestBody CreateOrderRequest request) {
        ordersService.create(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
