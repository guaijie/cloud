package com.example.order.server.dao;

import com.example.order.server.ServerApplicationTests;
import com.example.order.server.entity.UserOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
class OrderUserDaoTest extends ServerApplicationTests {

    @Autowired(required = false)
    private UserOrderDao userOrderDao;

    @Test
    public void addUserOrder(){
        UserOrder userOrder = new UserOrder();
        userOrder.setOrderAmount(100.30);
        userOrder.setUserId("97304531204ef7431330c20427d95481");
        userOrder.setOrderId("88304531204ef7431330c20427d95481");
        int flag=userOrderDao.addUserOrder(userOrder);
        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }
}