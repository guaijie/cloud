package com.example.order.dto;

import com.example.order.entity.OrderDetail;
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
