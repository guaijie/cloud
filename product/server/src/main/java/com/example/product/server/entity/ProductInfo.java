package com.example.product.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class ProductInfo {

    @Id
    @Column(name="id")
    private String productId;

    @Column(name="name")
    private String productName;

    @Column(name="price")
    private Double productPrice;

    @Column(name="stock")
    private Integer productStock;

    @Column(name="status")
    private Integer productStatus;


    @ManyToOne(fetch= FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name="type")
    @JsonIgnore
    private Category category;

    public String getCategoryName(){
        return category.getCategoryName();
    }

    public String getCategoryType(){
        return category.getCategoryType();
    }

    public String getCategoryId(){
        return category.getCategoryType();
    }

    @Column(name="desc")
    private String productDesc;

    private Date createTime;

    private Date updateTime;

}
