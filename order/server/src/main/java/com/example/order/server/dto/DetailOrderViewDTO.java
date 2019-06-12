package com.example.order.server.dto;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class DetailOrderViewDTO {

    private String orderId;

    private Integer size;

    private Integer start;

    public DetailOrderViewDTO(String orderId, Integer start, Integer size) {
        this.orderId = orderId;
        this.size = size;
        this.start = start;
    }
}
