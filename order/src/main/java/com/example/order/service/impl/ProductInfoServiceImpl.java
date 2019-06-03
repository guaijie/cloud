package com.example.order.service.impl;

import com.example.order.Enum.ProductStatusEnum;
import com.example.order.entity.ProductInfo;
import com.example.order.repository.ProductInfoRepository;
import com.example.order.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findProductByUp() {
        List<ProductInfo> list= productInfoRepository.findByProductStatus(0);

        return list;
    }
}
