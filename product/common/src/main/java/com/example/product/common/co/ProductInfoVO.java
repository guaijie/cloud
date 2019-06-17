package com.example.product.common.co;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private Double productPrice;

    @JsonProperty("desc")
    private String productDesc;

    @JsonProperty("stock")
    private Integer productStock;

    private String categoryName;

    private String categoryType;

}
