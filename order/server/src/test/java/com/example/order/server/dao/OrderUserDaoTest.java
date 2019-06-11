package com.example.order.server.dao;

import com.example.order.server.ServerApplicationTests;
import com.example.order.server.entity.OrderUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
class OrderUserDaoTest extends ServerApplicationTests {

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