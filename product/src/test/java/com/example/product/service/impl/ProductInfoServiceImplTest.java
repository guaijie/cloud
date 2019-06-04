package com.example.product.service.impl;

import com.example.product.ProductApplicationTests;
import com.example.product.entity.ProductInfo;
import com.example.product.service.ProductInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ProductInfoServiceImplTest extends ProductApplicationTests {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    void findProductInfosByStatus() {
        Page<ProductInfo> page=productInfoService.findProductInfosByStatus(0,1,1);
        Assert.assertTrue(page.hasContent());
    }

    @Test
    void findProductInfosByPages() {

        Page<ProductInfo> page=productInfoService.findProductInfosByPages(2,2);
        Assert.assertTrue(page.hasContent());
    }

    @Test
    void findProductInfosByType() {
        Page<ProductInfo> page=productInfoService.findProductInfosByType("00001",1,1);
        Assert.assertTrue(page.hasContent());
    }

    @Test
    void findProductInfosByTypeAndStatus() {
        Page<ProductInfo> page=productInfoService.findProductInfosByTypeAndStatus("00001",0,1,1);
        Assert.assertTrue(page.hasContent());
    }
}