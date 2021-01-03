package com.agh.service;

import com.agh.model.Categories;
import com.agh.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Categories> getAll() {
        return categoriesRepository.getAll();
    }

    public Categories getById(Short categoryId) {
        return categoriesRepository.getById(categoryId).orElseThrow(IllegalArgumentException::new);
    }
}
