package com.example.product.service;

import com.example.product.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductInfoService {

    Page<ProductInfo> findProductInfosByStatus(Integer productStatus,Integer offset, Integer limit);

    Page<ProductInfo> findProductInfosByPages(Integer offset, Integer limit);

    Page<ProductInfo> findProductInfosByType(String categoryType,Integer offset, Integer limit);

    Page<ProductInfo> findProductInfosByTypeAndStatus(String categoryType, Integer productStatus,Integer offset, Integer limit);
}
