package com.example.product.service.impl;

import com.example.product.repository.ProductInfoRepository;
import com.example.product.entity.ProductInfo;
import com.example.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public Page<ProductInfo> findProductInfosByStatus(Integer productStatus,Integer offset, Integer limit) {
        Pageable pageable= (Pageable) PageRequest.of(offset,limit);
        Page<ProductInfo> page= productInfoRepository.findByProductStatus(productStatus,pageable);
        return page;
    }

    @Override
    public Page<ProductInfo> findProductInfosByPages(Integer offset, Integer limit) {
        Pageable pageable= (Pageable) PageRequest.of(offset,limit);
        Page<ProductInfo> page= productInfoRepository.findAll(pageable);
        return page;
    }

    @Override
    public Page<ProductInfo> findProductInfosByType(String categoryType,Integer offset, Integer limit) {
        Pageable pageable= (Pageable) PageRequest.of(offset,limit);
        Page<ProductInfo> page= productInfoRepository.findByCategoryType(categoryType,pageable);
        return page;
    }

    @Override
    public Page<ProductInfo> findProductInfosByTypeAndStatus(String categoryType, Integer productStatus,Integer offset, Integer limit) {
        Pageable pageable= (Pageable) PageRequest.of(offset,limit);
        Page<ProductInfo> page= productInfoRepository.findByCategoryTypeAndProductStatus(categoryType,productStatus,pageable);
        return page;
    }
}
