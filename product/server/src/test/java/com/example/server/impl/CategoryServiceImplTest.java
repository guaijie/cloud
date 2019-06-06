package com.example.server.impl;

import com.example.server.entity.Category;
import com.example.server.service.CategoryService;
import com.example.server.ServerApplicationTests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class CategoryServiceImplTest extends ServerApplicationTests {

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