package com.example.product.client;

import com.example.product.common.co.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="product")
public interface ProductClient {

    @RequestMapping("product/productInfosForOrder")
    List<ProductInfoCO> getProductInfosByProductIdIn(@RequestParam(required = false) List<String> productIdList);

    @PostMapping("product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

    @RequestMapping("category/categories")
    public ResultVO getCategories(@RequestParam(required = false) String categoryType);

    @RequestMapping("product/productInfos")
    public ResultByPageVO<ProductInfoVO> getProductInfos(
            @RequestParam(required=false) Integer status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Integer counts
    );
}
