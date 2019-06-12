package com.example.order.server.service.impl;


import com.example.order.server.dao.DetailOrderDao;
import com.example.order.server.dao.UserOrderDao;
import com.example.order.server.dto.DetailOrderViewDTO;
import com.example.order.server.dto.UserOrderDTO;
import com.example.order.server.dto.UserOrderViewDTO;
import com.example.order.server.entity.DetailOrder;
import com.example.order.server.entity.UserOrder;
import com.example.order.server.service.OrderService;
import com.example.order.server.util.MD5;
import com.example.order.server.util.UniqKey;
import com.example.order.server.vo.DetailOrderVO;
import com.example.order.server.vo.UserOrderVO;
import com.example.product.client.ProductClient;
import com.example.product.common.co.CartDTO;
import com.example.product.common.co.ProductInfoCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    /*
     * 查询商品信息
     * 计算总价
     * 扣库存
     * 订单入库
     * */

    @Autowired(required = false)
    private UserOrderDao userOrderDao;

    @Autowired
    private ProductClient productClient;

    @Autowired(required = false)
    private DetailOrderDao detailOrderDao;

    @Override
    @Transactional
    public UserOrderDTO createOrder(UserOrderDTO userOrderDTO) {
        String orderId = MD5.digest(UniqKey.genUniqKey(),userOrderDTO.getUserId());
        // 查询商品信息
        List<DetailOrder> detailOrderList = userOrderDTO.getDetailOrderList();
        List<String> productIdList = detailOrderList.stream()
                .map(DetailOrder::getProductId)
                .collect(Collectors.toList());

        List<ProductInfoCO> productInfoCOList = productClient.getProductInfosByProductIdIn(productIdList);

        // 计算总金额
        Double orderAmout=0.0;
        for(DetailOrder detailOrder:detailOrderList){
            for(ProductInfoCO productInfoCO:productInfoCOList){
                if(detailOrder.getProductId().equals(productInfoCO.getProductId())){
                    orderAmout += productInfoCO.getProductPrice()*detailOrder.getProductCounts();
                    BeanUtils.copyProperties(productInfoCO,detailOrder);
                    detailOrder.setOrderId(orderId);
                    String detailId = MD5.digest(UniqKey.genUniqKey(),orderId);
                    detailOrder.setId(detailId);
                    detailOrderDao.addOrderDetail(detailOrder);
                }
            }
        }

        // 扣库存
        List<CartDTO>  cartDTOList = userOrderDTO.getDetailOrderList()
                .stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductCounts()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 订单入库
        UserOrder userOrder = new UserOrder();

        userOrderDTO.setOrderId(orderId);
        userOrderDTO.setOrderAmount(orderAmout);
        BeanUtils.copyProperties(userOrderDTO,userOrder);
        userOrderDao.addUserOrder(userOrder);

        return userOrderDTO;
    }

    @Override
    public List<UserOrderVO> getUserOrderByPage(UserOrderViewDTO userOrderViewDTO) {

        List<UserOrderVO> userOrderList = userOrderDao.getUserOrderByPage(userOrderViewDTO);

        return userOrderList;
    }

    @Override
    public List<DetailOrderVO> getDetailOrderByPage(DetailOrderViewDTO detailOrderViewDTO) {

        List<DetailOrderVO> detailOrderVOList = detailOrderDao.getDetailOrderByPage(detailOrderViewDTO);

        return detailOrderVOList;
    }

    @Override
    public String deleteUserOrder(String userId, String orderId) {
        int flag = userOrderDao.deleteUserOrder(userId,orderId);
        if(flag==1){
            detailOrderDao.deleteOrderDetail(orderId);
            return orderId;
        }
        return null;
    }
}
