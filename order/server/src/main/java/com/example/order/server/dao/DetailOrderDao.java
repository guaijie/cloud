package com.example.order.server.dao;

import com.example.order.server.entity.DetailOrder;
import org.apache.ibatis.annotations.Mapper;

public interface DetailOrderDao {

    int addOrderDetail(DetailOrder detailOrder);
}
