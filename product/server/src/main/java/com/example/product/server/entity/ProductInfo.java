package com.example.product.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@ApiModel(value = "产品Entity")
public class ProductInfo {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "产品id")
    private String productId;

    @Column(name = "name")
    @ApiModelProperty(value = "产品名")
    private String productName;

    @Column(name = "price")
    @ApiModelProperty(value = "产品价格")
    private Double productPrice;

    @Column(name = "stock")
    @ApiModelProperty(value = "产品库存")
    private Integer productStock;

    @Column(name = "status")
    @ApiModelProperty(value = "产品状态")
    private Integer productStatus;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "type")
    @JsonIgnore
    @ApiModelProperty(value = "产品所属类目")
    private Category category;

    public String getCategoryName() {
        return category.getCategoryName();
    }

    public String getCategoryType() {
        return category.getCategoryType();
    }

    public String getCategoryId() {
        return category.getCategoryType();
    }

    @Column(name = "desc")
    @ApiModelProperty(value = "产品描述")
    private String productDesc;

    @ApiModelProperty(value = "产品创建时间")
    private Date createTime;

    @ApiModelProperty(value = "产品更新时间")
    private Date updateTime;

}
