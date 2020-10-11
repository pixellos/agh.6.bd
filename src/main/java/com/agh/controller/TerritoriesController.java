package com.agh.controller;

import com.agh.model.Territories;
import com.agh.service.TerritoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TerritoriesController {
    private static Logger LOGGER = LoggerFactory.getLogger(TerritoriesController.class);

    private final TerritoriesService territoriesService;

    @Autowired
    public TerritoriesController(TerritoriesService territoriesService) {
        this.territoriesService = territoriesService;
    }

    @GetMapping("territories")
    public ResponseEntity<List<Territories>> getAll() {
        LOGGER.info("TerritoriesController - getAll invoked");
        List<Territories> territories = territoriesService.getAll();
        return new ResponseEntity<>(territories, HttpStatus.OK);
    }
}
