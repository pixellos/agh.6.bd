package com.agh.controller;

import com.agh.model.OrderDetails;
import com.agh.request.CreateOrderDetailsRequest;
import com.agh.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("orderDetails/order/{orderId}")
    public ResponseEntity<List<OrderDetails>> getByOrderId(@PathVariable Short orderId) {
        return new ResponseEntity<>(orderDetailsService.getByOrderId(orderId), HttpStatus.OK);
    }

    @GetMapping("orderDetails/product/{productId}")
    public ResponseEntity<List<OrderDetails>> getByProductId(@PathVariable Short productId) {
        return new ResponseEntity<>(orderDetailsService.getByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("orderDetails/product/category/{categoryName}")
    public ResponseEntity<List<OrderDetails>> getByProductCategory(@PathVariable String categoryName) {
        return new ResponseEntity<>(orderDetailsService.getByProductCategory(categoryName), HttpStatus.OK);
    }

    @GetMapping("orderDetails/product/supplier/{supplierId}")
    public ResponseEntity<List<OrderDetails>> getBySupplierId(@PathVariable Short supplierId) {
        return new ResponseEntity<>(orderDetailsService.getBySupplierId(supplierId), HttpStatus.OK);
    }

    @PostMapping("orderDetails")
    public ResponseEntity<Void> create(@RequestBody CreateOrderDetailsRequest request) {
        orderDetailsService.create(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
