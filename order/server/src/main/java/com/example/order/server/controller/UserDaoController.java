package com.example.order.server.controller;

import com.example.product.client.ProductClient;
import com.example.product.common.co.ProductInfoCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
public class UserDaoController {

    @Autowired
    ProductClient productClient;

    @RequestMapping("productInfos")
    public List<ProductInfoCO> getProductInfosByProductIdIn(@RequestParam(required = true) List<String> productIdList){

        List<ProductInfoCO> list= productClient.getProductInfosByProductIdIn(Arrays.asList("0000000001"));

        return list;
    }
}
