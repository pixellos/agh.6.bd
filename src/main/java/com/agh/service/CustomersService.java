package com.agh.service;

import com.agh.model.Customers;
import com.agh.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> getAll() {
        return customersRepository.getAll();
    }

    public Customers getById(String customerId) {
        return customersRepository.getById(customerId).orElseThrow(IllegalArgumentException::new);
    }
}
