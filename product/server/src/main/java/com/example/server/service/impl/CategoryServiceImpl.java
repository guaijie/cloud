package com.example.server.service.impl;

import com.example.server.entity.Category;
import com.example.server.repository.CategoryRepository;
import com.example.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findALlCategories() {
        List<Category> list=categoryRepository.findAll();
        return list;
    }

    @Override
    public List<Category> findCategoriesByCategoryTypes(List<String> categoryTypes) {

        List<Category> list=categoryRepository.findAllByCategoryTypeIn(categoryTypes);

        return list;
    }
}
