package com.example.product.server.entity;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@ApiModel(value = "产品类目Entity")
public class Category {

    @Column(name = "id")
    @Id
    @GeneratedValue
    @ApiModelProperty(value = "产品类目id")
    private Integer categoryId;

    @Column(name = "type")
    @ApiModelProperty(value = "产品类目类型")
    private String categoryType;

    @Column(name = "name")
    @ApiModelProperty(value = "产品类目名称")
    private String categoryName;

    @ApiModelProperty(value = "产品类目创建时间")
    private Date createTime;

    @ApiModelProperty(value = "产品类目更新时间")
    private Date updateTime;
}
