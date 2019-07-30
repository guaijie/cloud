package com.example.product.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "分页结果vo")
public class ResultByPageVO<T> {

    @ApiModelProperty(value = "返回状态码")
    private Integer code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "数据列表")
    private List<T> dataList;

    @ApiModelProperty(value = "数据条目总计")
    private long totalNumber;

    @ApiModelProperty(value = "当前条目数量")
    private Integer currentNumber;

    @ApiModelProperty(value = "当前页码")
    private Integer currentPage;
}
