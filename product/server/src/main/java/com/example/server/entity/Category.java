package com.example.server.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Category {

    @Column(name="id")
    @Id
    @GeneratedValue
    private Integer categoryId;

    @Column(name="type")
    private String categoryType;

    @Column(name="name")
    private String categoryName;

    private Date createTime;

    private Date updateTime;
}
