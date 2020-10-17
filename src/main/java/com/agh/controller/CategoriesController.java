package com.agh.controller;

import com.agh.model.Categories;
import com.agh.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("categories")
    public ResponseEntity<List<Categories>> getAll() {
        return new ResponseEntity<>(categoriesService.getAll(), HttpStatus.OK);
    }
}
