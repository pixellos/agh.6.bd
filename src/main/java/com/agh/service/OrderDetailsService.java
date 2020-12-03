package com.agh.service;

import com.agh.model.OrderDetails;
import com.agh.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<OrderDetails> getAll() {
        return orderDetailsRepository.getAll();
    }

    public List<OrderDetails> getByOrderId(Short orderId) {
        return orderDetailsRepository.getByOrderId(orderId);
    }

    public List<OrderDetails> getByProductId(Short productId) {
        return orderDetailsRepository.getByProductId(productId);
    }

    public List<OrderDetails> getByProductCategory(String categoryName) {
        return orderDetailsRepository.getByProductCategory(categoryName);
    }

    public List<OrderDetails> getBySupplierId(Short supplierId) {
        return orderDetailsRepository.getBySupplierId(supplierId);
    }
}
