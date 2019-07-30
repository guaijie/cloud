package com.example.product.common.co;

import lombok.Data;

@Data
public class CartDTO {

    private String productId;

    private Integer productCounts;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productCounts) {

        this.productCounts = productCounts;
        this.productId = productId;
    }
}
