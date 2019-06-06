package com.example.client;

import com.example.common.co.ProductInfoCO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product")
public interface ProductClient {

    @RequestMapping("product/productInfosForOrder")
    Page<ProductInfoCO> getProductInfos();
}
