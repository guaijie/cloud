package com.example.order.server.vo;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class DetailOrderVO {

    @Id
    private String id;

    private Integer total;

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
