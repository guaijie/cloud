package com.example.server.client;

import com.example.server.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product")
public interface ProductClient {

    @RequestMapping("product/productInfosForOrder")
    Page<ProductInfo> getProductInfos();
}
