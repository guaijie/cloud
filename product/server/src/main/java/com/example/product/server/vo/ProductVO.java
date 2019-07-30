package com.example.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "产品vo")
public class ProductVO {

    @JsonProperty("name")
    @ApiModelProperty(value = "类目名")
    private String categoryName;

    @JsonProperty("type")
    @ApiModelProperty(value = "类目类型")
    private String categoryType;

    @JsonProperty("dataList")
    @ApiModelProperty(value = "产品信息列表")
    private List productInfoVOList;

}
