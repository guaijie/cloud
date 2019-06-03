package com.example.product.service;

import com.example.product.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductInfoService {

    public List<ProductInfo> findProductByUp();

}
