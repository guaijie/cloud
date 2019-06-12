package com.example.order.server.controller;

import com.example.product.client.ProductClient;
import com.example.product.common.co.ProductInfoVO;
import com.example.product.common.co.ResultByPageVO;
import com.example.product.common.co.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@Slf4j
public class productInfoController {

    @Autowired
    ProductClient productClient;

    @RequestMapping("categories")
    public ResultVO getCategories(@RequestParam(required = false) String categoryType){

        ResultVO resultVO = productClient.getCategories(categoryType);

        return resultVO;
    }

    @RequestMapping("productInfos")
    public ResultByPageVO<ProductInfoVO> getProductInfos(
            @RequestParam(required=false) Integer status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Integer counts
    ){

        ResultByPageVO resultByPageVO = productClient.getProductInfos(status,type,pages,counts);

        return resultByPageVO;
    }

}
