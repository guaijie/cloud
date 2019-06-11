package com.example.product.server.impl;

import com.example.product.server.ServerApplicationTests;
import com.example.product.server.dto.CartDTO;
import com.example.product.server.entity.ProductInfo;
import com.example.product.server.service.ProductInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class ProductInfoServiceImplTest extends ServerApplicationTests {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void findProductInfosByStatus() {
        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByStatus(0,1,1);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    public void findProductInfosByPages() {

        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByPages(2,2);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    public void findProductInfosByType() {
        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByType("00001",1,1);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    public void findProductInfosByTypeAndStatus() {
        Page<ProductInfo> pageWrapper=productInfoService.findProductInfosByTypeAndStatus("00001",0,1,1);
        Assert.assertTrue(pageWrapper.hasContent());
    }

    @Test
    public void findProductInfosByProductIdIn() {
        List<ProductInfo> list= productInfoService.findProductInfosByProductIdIn(Arrays.asList("0000000001"));
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void deccreaseStock() throws Exception{
        CartDTO cartDTO = new CartDTO("0000000001",2);
        productInfoService.decreseStock(Arrays.asList(cartDTO));
    }

}