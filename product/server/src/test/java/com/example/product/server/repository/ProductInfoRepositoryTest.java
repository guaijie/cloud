package com.example.product.server.repository;

import com.example.product.server.ServerApplicationTests;
import com.example.product.server.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProductInfoRepositoryTest extends ServerApplicationTests {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        Pageable pageable = (Pageable) PageRequest.of(1, 1);
        Page<ProductInfo> page = productInfoRepository.findByProductStatus(0, pageable);
        Assert.assertTrue(page.hasContent());
    }

    @Test
    public void findAll() {
        Pageable pageable = (Pageable) PageRequest.of(1, 1);
        Page<ProductInfo> page = productInfoRepository.findAll(pageable);
        System.out.println(page.getContent());
        Assert.assertTrue(page.hasContent());
    }
}

