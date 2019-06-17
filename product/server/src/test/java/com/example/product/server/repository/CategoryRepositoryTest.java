package com.example.product.server.repository;

import com.example.product.server.ServerApplicationTests;
import com.example.product.server.entity.Category;
import lombok.Value;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepositoryTest extends ServerApplicationTests {

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