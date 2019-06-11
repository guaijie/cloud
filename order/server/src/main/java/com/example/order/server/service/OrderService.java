package com.example.order.server.service;

import com.example.order.server.dto.UserOrderDTO;

public interface OrderService {

    UserOrderDTO createOrder(UserOrderDTO userOrderDTO);
}



