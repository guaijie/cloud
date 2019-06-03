package com.example.product.service.impl;

import com.example.product.Enum.ProductStatusEnum;
import com.example.product.repository.ProductInfoRepository;
import com.example.product.entity.ProductInfo;
import com.example.product.repository.ProductInfoRepository;
import com.example.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findProductByUp() {
        List<ProductInfo> list= productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());

        return list;
    }
}
