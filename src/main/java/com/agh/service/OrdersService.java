package com.agh.service;

import com.agh.model.Orders;
import com.agh.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAll() {
        return ordersRepository.getAll();
    }

    public List<Orders> getAllByCustomerId(String customerId) {
        return ordersRepository.getAllByCustomerId(customerId);
    }

    public List<Orders> getAllByEmployeeId(Short employeeId) {
        return ordersRepository.getAllByEmployeeId(employeeId);
    }

    public List<Orders> getAllByShipperId(Short shipperId) {
        return ordersRepository.getAllByShipperId(shipperId);
    }
}
