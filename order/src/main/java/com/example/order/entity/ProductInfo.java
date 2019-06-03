package com.example.order.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProductInfo {

    @Id
    @Column(name="id")
    protected Integer productId;
    @Column(name="name")
    private String productName;
    @Column(name="price")
    private Float productPrice;
    @Column(name="stock")
    private Integer productStock;
    @Column(name="status")
    private Integer productStatus;
    @Column(name="categories")
    private Enum productCategories;
    @Column(name="brand_id")
    private Integer productBrandId;
    @Column(name="desc")
    private String productDesc;
    private Date createTime;
    private Date updateTime;

}
