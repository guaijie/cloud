package com.example.product.service.impl;

import com.example.product.ProductApplicationTests;
import com.example.product.entity.Category;
import com.example.product.service.CategoryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    CategoryService categoryService;

    @Test
    void findALlCategories() {
        List<Category> list=categoryService.findALlCategories();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    void findCategoriesByCategoryTypes() {
        List<Category> list=categoryService.findCategoriesByCategoryTypes(Arrays.asList("00001"));
        Assert.assertTrue(list.size()>0);
    }

}