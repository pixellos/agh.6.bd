package com.agh.controller;

import com.agh.model.Region;
import com.agh.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("regions")
    public ResponseEntity<List<Region>> getAll() {
        return new ResponseEntity<>(regionService.getAll(), HttpStatus.OK);
    }
}
