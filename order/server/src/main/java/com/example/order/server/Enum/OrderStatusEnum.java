package com.example.order.server.Enum;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    NORM(0, "正常"),
    COMP(1, "完成"),
    CANC(1, "取消");
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
