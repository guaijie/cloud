package com.example.product.server.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    PRODUCT_NOT_EXIST(0, "商品不存在！"),
    PRODUCT_STOCK_ERROR(1, "库存有误！");

    private Integer code;

    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
