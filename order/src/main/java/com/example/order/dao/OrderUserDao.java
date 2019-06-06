package com.example.order.dao;

import com.example.order.entity.OrderUser;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

public interface OrderUserDao {

    int addUserOrder(OrderUser orderUser);
}
