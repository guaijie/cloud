package com.example.order.server.Enum;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    PAYED(0,"未支付"),
    UNPAY(1, "已支付");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
