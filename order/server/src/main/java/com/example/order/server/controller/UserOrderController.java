package com.example.order.server.controller;

import com.example.order.server.dto.CartParamDTO;
import com.example.order.server.dto.DetailOrderViewDTO;
import com.example.order.server.dto.UserOrderDTO;
import com.example.order.server.dto.UserOrderViewDTO;
import com.example.order.server.entity.DetailOrder;
import com.example.order.server.service.OrderService;
import com.example.order.server.vo.DetailOrderVO;
import com.example.order.server.vo.ResultByPageVO;
import com.example.order.server.vo.ResultVO;
import com.example.order.server.vo.UserOrderVO;
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
public class UserOrderController {

    @Autowired
    ProductClient productClient;

    @Autowired
    OrderService orderService;

    private final Integer COUNTS=10;

    private final Integer PAGES=1;

    @RequestMapping("productInfos")
    public List<ProductInfoCO> getProductInfosByProductIdIn(@RequestParam(required = true) List<String> productIdList){

        List<ProductInfoCO> list= productClient.getProductInfosByProductIdIn(productIdList);

        return list;
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

    @RequestMapping("userOrders")
    public ResultByPageVO getUserOrders(
            @RequestParam(required = false) Integer orderStatus,
            @RequestParam(required = false) Integer payStatus,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Integer counts
    ){
        if(pages==null || pages.toString().equals("")){
            pages=PAGES;
        }
        if(counts==null || counts.toString().equals("")){
            counts=COUNTS;
        }

        Integer start = (pages-1) * counts;

        UserOrderViewDTO userOrderViewDTO =new UserOrderViewDTO(orderStatus,payStatus,start,counts);

        List<UserOrderVO> userOrderVOList = orderService.getUserOrderByPage(userOrderViewDTO);

        ResultByPageVO<UserOrderVO> resultByPageVO = new ResultByPageVO<UserOrderVO>();

        Integer totalNumber = userOrderVOList.size()==0 ? 0 : userOrderVOList.get(0).getTotal();

        resultByPageVO.setCode(200);
        resultByPageVO.setMsg("订单查询成功！");
        resultByPageVO.setCurrentNumber(userOrderVOList.size());
        resultByPageVO.setCurrentPage(pages);
        resultByPageVO.setTotalNumber(totalNumber);
        resultByPageVO.setDataList(userOrderVOList);

        return resultByPageVO;
    }

    @RequestMapping("detailOrders")
    public ResultByPageVO getdetailOrders(
            @RequestParam(required = false) String orderId,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Integer counts
    ){
        if(pages==null || pages.toString().equals("")){
            pages=PAGES;
        }
        if(counts==null || counts.toString().equals("")){
            counts=COUNTS;
        }

        Integer start = (pages-1) * counts;

        DetailOrderViewDTO detailOrderViewDTO =new DetailOrderViewDTO(orderId,start,counts);

        List<DetailOrderVO> detailOrderVOList = orderService.getDetailOrderByPage(detailOrderViewDTO);

        ResultByPageVO<DetailOrderVO> resultByPageVO = new ResultByPageVO<DetailOrderVO>();

        Integer totalNumber = detailOrderVOList.size()==0 ? 0 : detailOrderVOList.get(0).getTotal();

        resultByPageVO.setCode(200);
        resultByPageVO.setMsg("订单查询成功！");
        resultByPageVO.setCurrentNumber(detailOrderVOList.size());
        resultByPageVO.setCurrentPage(pages);
        resultByPageVO.setTotalNumber(totalNumber);
        resultByPageVO.setDataList(detailOrderVOList);

        return resultByPageVO;
    }

    @RequestMapping("deleteUserOrder")
    public ResultVO delteUserOrder(
            @RequestParam String orderId,
            @RequestParam String userId
    ){
        String str = orderService.deleteUserOrder(userId,orderId);
        ResultVO resultVO = new ResultVO();
        if(str == null){
            resultVO.setCode(400);
            resultVO.setMsg("订单不存在！");
        }else{
            resultVO.setCode(200);
            resultVO.setMsg("订单删除成功！");
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderId",orderId);
        resultVO.setData(map);

        return resultVO;
    }

}
