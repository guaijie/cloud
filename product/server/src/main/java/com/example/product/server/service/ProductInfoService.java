package com.example.product.server.service;

import com.example.product.server.dto.CartDTO;
import com.example.product.server.entity.ProductInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductInfoService {

    Page<ProductInfo> findProductInfosByStatus(Integer productStatus, Integer page, Integer size);

    Page<ProductInfo> findProductInfosByPages(Integer page, Integer size);

    Page<ProductInfo> findProductInfosByType(String categoryType, Integer page, Integer size);

    Page<ProductInfo> findProductInfosByTypeAndStatus(String categoryType, Integer productStatus, Integer page, Integer size);

    List<ProductInfo> findProductInfosByProductIdIn(List<String> productIdList);

    void decreseStock(List<CartDTO> cartDTOList);
}
