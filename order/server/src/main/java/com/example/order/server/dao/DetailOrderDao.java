package com.example.order.server.dao;

import com.example.order.server.dto.DetailOrderViewDTO;
import com.example.order.server.entity.DetailOrder;
import com.example.order.server.vo.DetailOrderVO;

import java.util.List;

public interface DetailOrderDao {

    int addOrderDetail(DetailOrder detailOrder);

    int deleteOrderDetail(String orderId);

    List<DetailOrderVO> getDetailOrderByPage(DetailOrderViewDTO detailOrderViewDTO);
}
