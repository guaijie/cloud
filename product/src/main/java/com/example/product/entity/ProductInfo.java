package com.example.product.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class ProductInfo implements Serializable {

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

    private String categoryType;

    @Column(name="desc")
    private String productDesc;

    private Date createTime;

    private Date updateTime;

}
