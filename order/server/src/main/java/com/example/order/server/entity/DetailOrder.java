package com.example.order.server.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class DetailOrder {

    @Id
    private String id;

    private String orderId;

    private String productId;

    private String productName;

    private Double productPrice;

    private Integer productCounts;

    private String categoryName;

    private String categoryType;

    private Date createTime;

    private Date updateTime;
}
