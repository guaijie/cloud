package com.example.server.service.impl;

import com.example.server.entity.ProductInfo;
import com.example.server.repository.ProductInfoRepository;
import com.example.server.service.ProductInfoService;
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
    public Page<ProductInfo> findProductInfosByStatus(Integer productStatus,Integer page, Integer size) {
        Pageable pageable= (Pageable) PageRequest.of(page,size);
        Page<ProductInfo> pageWrapper= productInfoRepository.findByProductStatus(productStatus,pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByPages(Integer page, Integer size) {
        Pageable pageable= (Pageable) PageRequest.of(page,size);
        Page<ProductInfo> pageWrapper= productInfoRepository.findAll(pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByType(String categoryType,Integer page, Integer size) {
        Pageable pageable= (Pageable) PageRequest.of(page,size);
        Page<ProductInfo> pageWrapper= productInfoRepository.findByCategory_CategoryType(categoryType,pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByTypeAndStatus(String categoryType, Integer productStatus,Integer page, Integer size) {
        Pageable pageable= (Pageable) PageRequest.of(page,size);
        Page<ProductInfo> pageWrapper= productInfoRepository.findByCategory_CategoryTypeAndProductStatus(categoryType,productStatus,pageable);
        return pageWrapper;
    }

    @Override
    public Page<ProductInfo> findProductInfosByProductIdIn(List<String> productIdList ,Integer page, Integer size) {
        Pageable pageable= (Pageable) PageRequest.of(page,size);
        Page<ProductInfo> pageWrapper= productInfoRepository.findByProductIdIn(productIdList,pageable);
        return pageWrapper;
    }
}
