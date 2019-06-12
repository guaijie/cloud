package com.example.order.server.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class UserOrderVO {

    @JsonIgnore
    private Integer total;

    private String orderId;

    private String userId;

    private Double orderAmount;

    private  Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;
}
