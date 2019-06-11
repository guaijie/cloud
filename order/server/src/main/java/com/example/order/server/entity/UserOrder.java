package com.example.order.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserOrder {

    private String orderId;

    private String userId;

    private Double orderAmount;

    private  Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;
}
