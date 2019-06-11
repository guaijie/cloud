package com.example.order.server.controller;

import com.example.order.server.dto.CartParamDTO;
import com.example.order.server.dto.UserOrderDTO;
import com.example.order.server.entity.DetailOrder;
import com.example.order.server.service.OrderService;
import com.example.order.server.vo.ResultVO;
import com.example.product.client.ProductClient;
import com.example.product.common.co.CartDTO;
import com.example.product.common.co.ProductInfoCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("order")
@Slf4j
public class UserDaoController {

    @Autowired
    ProductClient productClient;

    @Autowired
    OrderService orderService;

    @RequestMapping("productInfos")
    public List<ProductInfoCO> getProductInfosByProductIdIn(@RequestParam(required = true) List<String> productIdList){

        List<ProductInfoCO> list= productClient.getProductInfosByProductIdIn(productIdList);

        return list;
    }

    @PostMapping("decreaseStock")
    public String decreaseStock(){

        CartDTO cartDTO = new CartDTO("0000000003",4);
        productClient.decreaseStock(Arrays.asList(cartDTO));
        return "ok";
    }

    @PostMapping("addUserOrder")
    public ResultVO addUserOrder(
            @RequestBody CartParamDTO cartParamDTO
    ){

        UserOrderDTO userOrderDTO = new UserOrderDTO();

        userOrderDTO.setUserId(cartParamDTO.getUserId());
        List<DetailOrder> detailOrderList = new ArrayList<DetailOrder>();


        for(CartDTO cartDTO:cartParamDTO.getCartDTOList()){
            DetailOrder detailOrder = new DetailOrder();
            BeanUtils.copyProperties(cartDTO,detailOrder);
            detailOrderList.add(detailOrder);
        }
        userOrderDTO.setDetailOrderList(detailOrderList);

        userOrderDTO=orderService.createOrder(userOrderDTO);

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(200);
        resultVO.setMsg("创建订单成功");
        Map<String,String> map =new HashMap<String,String>();
        map.put("orderId",userOrderDTO.getOrderId());
        resultVO.setData(map);

        return resultVO;
    }

}
