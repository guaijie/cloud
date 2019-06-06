package com.example.order.service.impl;

import com.example.order.dao.OrderUserDao;
import com.example.order.dto.OrderDTO;
import com.example.order.entity.OrderUser;
import com.example.order.service.OrderService;
import com.example.order.util.MD5;
import com.example.order.util.UniqKey;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    /*
     * 查询商品信息
     * 计算总价
     * 扣库存
     * 订单入库
     * */

    @Autowired
    private OrderUserDao orderUserDao;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        //订单入库
        OrderUser orderUser = new OrderUser();
        String orderId = MD5.digest(UniqKey.genUniqKey(),orderDTO.getUserId());
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderUser);
        orderUser.setOrderAmount(5.12);
        orderUserDao.addUserOrder(orderUser);

        return null;
    }
}
