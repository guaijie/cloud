package com.example.product.repository;


import com.example.product.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    //分页查询
    Page<ProductInfo> findAll(Pageable pageable);

    //根据状态查询
    Page<ProductInfo> findByProductStatus(Integer productStatus,Pageable pageable);

    //根据类目查询
    Page<ProductInfo> findByCategoryType(String categoryType,Pageable pageable);

    //根据类目和状态查询
    Page<ProductInfo> findByCategoryTypeAndProductStatus(String categoryType,Integer productStatus,Pageable pageable);
}
