package com.example.order.server.dao;

import com.example.order.server.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;

public interface UserOrderDao {

    int addUserOrder(UserOrder userOrder);
}
