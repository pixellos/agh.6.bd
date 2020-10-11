package com.agh.service;

import com.agh.model.Territories;
import com.agh.repository.TerritoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerritoriesService {
    private final TerritoriesRepository repository;

    @Autowired
    public TerritoriesService(TerritoriesRepository repository) {
        this.repository = repository;
    }

    public List<Territories> getAll() {
        return repository.getAll();
    }
}
