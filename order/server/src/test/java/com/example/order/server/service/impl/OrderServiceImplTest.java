package com.example.order.server.service.impl;

import com.example.order.server.ServerApplicationTests;
import com.example.order.server.dto.DetailOrderViewDTO;
import com.example.order.server.dto.UserOrderDTO;
import com.example.order.server.entity.DetailOrder;
import com.example.order.server.service.OrderService;
import com.example.order.server.vo.DetailOrderVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class OrderServiceImplTest extends ServerApplicationTests {

    @Autowired(required = false)
    OrderService orderService;

    @Test
    void createOrder() {
        UserOrderDTO userOrderDTO = new UserOrderDTO();
        userOrderDTO.setUserId("97304531204ef7431330c20427d95485");
        DetailOrder detailOrder = new DetailOrder();
        detailOrder.setProductId("0000000003");
        detailOrder.setProductCounts(7);
        userOrderDTO.setDetailOrderList(Arrays.asList(detailOrder));
        System.out.println(userOrderDTO.toString());
        orderService.createOrder(userOrderDTO);
    }

    @Test
    public void getDetailOrderByPage(){
        DetailOrderViewDTO detailOrderViewDTO = new DetailOrderViewDTO("b567c0c5616794f6e4b9252d6efd65f5",0,5);
        List<DetailOrderVO> detailOrderList = orderService.getDetailOrderByPage(detailOrderViewDTO);

        System.out.println(detailOrderList.toString());
        Assert.assertTrue(detailOrderList.size()>0);
    }
}