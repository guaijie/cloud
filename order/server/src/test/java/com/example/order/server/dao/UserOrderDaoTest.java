package com.example.order.server.dao;

import com.example.order.server.ServerApplicationTests;
import com.example.order.server.dto.UserOrderViewDTO;
import com.example.order.server.entity.UserOrder;
import com.example.order.server.vo.UserOrderVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
class UserOrderDaoTest extends ServerApplicationTests {

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
    @Test
    public void getUserOrderByPage(){
        UserOrderViewDTO userOrderViewDTO =new UserOrderViewDTO(null,null,5,5);
        List<UserOrderVO> userOrderVOList= userOrderDao.getUserOrderByPage(userOrderViewDTO);
        System.out.println(userOrderVOList.toString());
        Assert.assertTrue(userOrderVOList.size()>0);
    }

    @Test
    public void deleteUserOrder(){

        int flag = userOrderDao.deleteUserOrder("97304531204ef7431330c20427d95481","346a8380175ac8af7127847b4037f0c6");
        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }

    @Test
    public void updateUserPayStatus(){

        int flag = userOrderDao.updateUserPayStatus("97304531204ef7431330c20427d95481","88304531204ef7431330c20427d95481",1);
        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }

    @Test
    public void updateUserOrderStatus(){

        int flag = userOrderDao.updateUserOrderStatus("97304531204ef7431330c20427d95481","88304531204ef7431330c20427d95481",1);
        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }


}