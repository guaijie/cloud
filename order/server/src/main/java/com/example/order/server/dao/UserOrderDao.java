package com.example.order.server.dao;

import com.example.order.server.dto.UserOrderViewDTO;
import com.example.order.server.entity.UserOrder;
import com.example.order.server.vo.UserOrderVO;

import java.util.List;

public interface UserOrderDao {

    int addUserOrder(UserOrder userOrder);

    int deleteUserOrder(String userId,String orderId);

    int updateUserOrderStatus(String userId,String orderId,Integer orderStatus);

    int updateUserPayStatus(String userId, String orderId,Integer payStatus);

    List<UserOrderVO> getUserOrderByPage(UserOrderViewDTO userOrderViewDTO);
}
