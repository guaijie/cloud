package com.example.order.server.dto;

import lombok.Data;

@Data
public class UserOrderViewDTO {

    private Integer orderStatus;

    private Integer payStatus;

    private Integer size;

    private Integer start;

    public UserOrderViewDTO(Integer orderStatus, Integer payStatus, Integer start, Integer size) {
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.size = size;
        this.start = start;
    }
}
