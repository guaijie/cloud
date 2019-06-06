package com.example.common.co;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductInfoCO {

        @JsonProperty("id")
        private String productId;

        @JsonProperty("name")
        private String productName;

        @JsonProperty("price")
        private Double productPrice;

}
