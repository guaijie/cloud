package com.example.order.server.service;

import com.example.order.server.dto.DetailOrderViewDTO;
import com.example.order.server.dto.UserOrderDTO;
import com.example.order.server.dto.UserOrderViewDTO;
import com.example.order.server.vo.DetailOrderVO;
import com.example.order.server.vo.UserOrderVO;

import java.util.List;

public interface OrderService {

    UserOrderDTO createOrder(UserOrderDTO userOrderDTO);

    List<UserOrderVO> getUserOrderByPage(UserOrderViewDTO userOrderViewDTO);

    List<DetailOrderVO> getDetailOrderByPage(DetailOrderViewDTO detailOrderViewDTO);

    String deleteUserOrder(String userId,String orderId);
}



