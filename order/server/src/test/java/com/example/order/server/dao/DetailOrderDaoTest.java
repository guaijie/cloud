package com.example.order.server.dao;

import com.example.order.server.ServerApplicationTests;
import com.example.order.server.dto.DetailOrderViewDTO;
import com.example.order.server.entity.DetailOrder;
import com.example.order.server.vo.DetailOrderVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Test
    public void deleteDetailOrder(){
        int flag=detailOrderDao.deleteOrderDetail("039a953d952a71ed0a3034f48f699c7d");
        System.out.println("flag:"+flag);
        Assert.assertTrue(flag==1);
    }

    @Test
    public void getDetailOrderByPage(){
        DetailOrderViewDTO detailOrderViewDTO = new DetailOrderViewDTO("b567c0c5616794f6e4b9252d6efd65f5",0,5);
        List<DetailOrderVO> detailOrderList = detailOrderDao.getDetailOrderByPage(detailOrderViewDTO);

        System.out.println(detailOrderList.toString());
        Assert.assertTrue(detailOrderList.size()>0);
    }
}