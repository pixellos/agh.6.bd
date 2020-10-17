package com.agh.service;

import com.agh.model.Shippers;
import com.agh.repository.ShippersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippersService {

    private final ShippersRepository shippersRepository;

    @Autowired
    public ShippersService(ShippersRepository shippersRepository) {
        this.shippersRepository = shippersRepository;
    }

    public List<Shippers> getAll() {
         return shippersRepository.getAll();
    }
}
