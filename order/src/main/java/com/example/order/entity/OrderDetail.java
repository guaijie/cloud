package com.example.order.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetail {

    private String id;

    private String orderId;

    private String productId;

    private String productName;

    private Double productPice;

    private Integer productCounts;

    private Date createTime;

    private Date updateTime;
}
