package com.example.order.server.dao;

import com.example.order.server.ServerApplicationTests;
import com.example.order.server.entity.DetailOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
class DetailOrderDaoTest extends ServerApplicationTests {

    @Autowired(required = false)
    private DetailOrderDao detailOrderDao;

    @Test
    public void addDetailOrder(){
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setProductCounts(4);
        detailOrder.setId("88304531204ef7431330c20427d95482");
        detailOrder.setOrderId("88304531204ef7431330c20427d95481");
        detailOrder.setProductId("0000000003");
        detailOrder.setProductPrice(2499.0);
        detailOrder.setCategoryName("手机");
        detailOrder.setCategoryType("00001");
        detailOrder.setProductName("荣耀手机");

        int flag=detailOrderDao.addOrderDetail(detailOrder);

        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }
}