package com.example.order.server.dto;

import com.example.order.server.entity.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private String orderId;

    private String userId;

    private Double orderAmount;

    private  Integer orderStatus;

    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
