package com.example.order.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderUser {

    private String orderId;

    private String userId;

    private Double orderAmount;

    private  Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;
}
