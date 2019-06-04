package com.example.product.repository;

import com.example.product.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Component
public class CategoryRepositoryTest extends ProductInfoRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findAll(){
        List<Category> list = categoryRepository.findAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findALLByCategoryTypeIn(){
        List<Category> list = categoryRepository.findAllByCategoryTypeIn(Arrays.asList("00001","00002"));
        Assert.assertTrue(list.size()>0);
    };


}