package com.example.product.controller;

import com.example.product.entity.ProductInfo;
import com.example.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("productInfo")
public class ProductInfoController {

    /**
     * 查询所有商品信息
     * 查询所有在架商品信息
     */

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("allProductInfo")
    public List<ProductInfo> getALlProductInfo(){
        List<ProductInfo> list=productInfoService.findProductByUp();
        HashMap<String,List> map= new HashMap<String,List>();
        return list;
    }

    @RequestMapping("hello")
    public String sayHello(){
       return "hello";
    }

}
