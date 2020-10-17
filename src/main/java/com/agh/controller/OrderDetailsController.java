package com.agh.controller;

import com.agh.model.OrderDetails;
import com.agh.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("orderDetails")
    public ResponseEntity<List<OrderDetails>> getAll() {
        return new ResponseEntity<>(orderDetailsService.getAll(), HttpStatus.OK);
    }
}
