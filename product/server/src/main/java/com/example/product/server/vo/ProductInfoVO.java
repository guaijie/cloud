package com.example.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "产品信息vo")
public class ProductInfoVO {

    @JsonProperty("id")
    @ApiModelProperty(value = "产品id")
    private String productId;

    @JsonProperty("name")
    @ApiModelProperty(value = "产品名")
    private String productName;

    @JsonProperty("price")
    @ApiModelProperty(value = "产品价格")
    private Double productPrice;

    @JsonProperty("desc")
    @ApiModelProperty(value = "产品描述")
    private String productDesc;

    @JsonProperty("stock")
    @ApiModelProperty(value = "产品库存")
    private Integer productStock;

    @ApiModelProperty(value = "类目名")
    private String categoryName;

    @ApiModelProperty(value = "类目类型")
    private String categoryType;

}
