package com.example.product.client;

import com.example.product.common.co.ProductInfoCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="product")
public interface ProductClient {

    @RequestMapping("product/productInfosForOrder")
    List<ProductInfoCO> getProductInfosByProductIdIn(@RequestParam(required = false) List<String> productIdList);
}
