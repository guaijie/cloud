package com.example.server.vo;

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

    @JsonProperty("description")
    private String productDesc;

    private String categoryName;

    private String categoryType;

}
