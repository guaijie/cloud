package com.example.order.dao;

import com.example.order.OrderApplicationTests;
import com.example.order.entity.OrderUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Component
class OrderUserDaoTest extends OrderApplicationTests {

    @Autowired(required = false)
    OrderUserDao orderUserDao;

    @Test
    void addUserOrder(){
        OrderUser orderUser = new OrderUser();
        orderUser.setOrderAmount(100.30);
        orderUser.setUserId("97304531204ef7431330c20427d95481");
        orderUser.setOrderId("88304531204ef7431330c20427d95481");
        int flag=orderUserDao.addUserOrder(orderUser);
        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }
}