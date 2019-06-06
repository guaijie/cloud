package com.example.order.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="product")
public interface ProductClient {

//    @RequestMapping("productInfo/productInfosForOrder")
//    @RequestMapping("product/productInfosForOrder")
//    Page<ProductInfo> getProductInfos();

    @RequestMapping("product/productInfosForOrder")
    Page<ProductInfo> getProductInfos();
}
