package com.example.server.impl;

import com.example.server.entity.ProductInfo;
import com.example.server.service.ProductInfoService;
import com.example.server.ServerApplicationTests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ProductInfoServiceImplTest extends ServerApplicationTests {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    void findProductInfosByStatus() {
        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByStatus(0,1,1);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    void findProductInfosByPages() {

        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByPages(2,2);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    void findProductInfosByType() {
        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByType("00001",1,1);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    void findProductInfosByTypeAndStatus() {
        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByTypeAndStatus("00001",0,1,1);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    void findProductInfosByProductIdIn() {
        Page<ProductInfo> pageWrapper= productInfoService.findProductInfosByProductIdIn(Arrays.asList("0000000001") ,0, 1);
        Assert.assertTrue(pageWrapper.getContent().size()>0);
    }
}