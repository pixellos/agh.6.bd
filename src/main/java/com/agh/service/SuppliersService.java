package com.agh.service;

import com.agh.model.Suppliers;
import com.agh.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;

    @Autowired
    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    public List<Suppliers> getAll() {
        return suppliersRepository.getAll();
    }
}
