package com.example.order.controller;

import com.example.order.entity.ProductInfo;
import com.example.order.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map getALlProductInfo(){
        List<ProductInfo> list=productInfoService.findProductByUp();
        HashMap<String,List> map= new HashMap<String,List>();
        map.put("data",list);
        return map;
    }

    @RequestMapping("hello")
    public String sayHello(){
       return "hello";
    }

}
