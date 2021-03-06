package com.example.product.server.controller;

import com.example.product.common.co.CartDTO;
import com.example.product.common.co.ProductInfoCO;
import com.example.product.server.service.CategoryService;
import com.example.product.server.vo.ProductInfoVO;
import com.example.product.server.entity.ProductInfo;
import com.example.product.server.service.ProductInfoService;
import com.example.product.server.vo.ResultByPageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("product")
@Slf4j
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    private final Integer COUNTS = 10;

    private final Integer PAGES = 1;

    /*
     * 根据类目和状态分页获取产品信息
     * */
    @RequestMapping("productInfos")
    public ResultByPageVO<ProductInfoVO> getProductInfos(
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Integer counts
    ) {
        Page<ProductInfo> pageWrapper;

        if (pages == null || pages.toString().equals("")) {
            pages = PAGES;
        }
        if (counts == null || counts.toString().equals("")) {
            counts = COUNTS;
        }
        pages = pages - 1;

        if ((status == null || status.toString().equals("")) && (type == null || type.equals(""))) {
            System.out.println(1);
            pageWrapper = productInfoService.findProductInfosByPages(pages, counts);
        } else if (type == null || type.equals("")) {
            System.out.println(2);
            pageWrapper = productInfoService.findProductInfosByStatus(status, pages, counts);
        } else if (status == null || status.toString().equals("")) {
            System.out.println(3);
            pageWrapper = productInfoService.findProductInfosByType(type, pages, counts);
        } else {
            System.out.println(4);
            pageWrapper = productInfoService.findProductInfosByTypeAndStatus(type, status, pages, counts);
        }

        //获取产品信息列表
        List<ProductInfo> productInfoList = pageWrapper.getContent();

        Integer currentNumber = productInfoList.size();

        List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();

        for (ProductInfo productInfo : productInfoList) {
            ProductInfoVO productInfoVO = new ProductInfoVO();
            BeanUtils.copyProperties(productInfo, productInfoVO);
            productInfoVOList.add(productInfoVO);
        }

        ResultByPageVO resultByPageVO = new ResultByPageVO();
        resultByPageVO.setCode(200);
        resultByPageVO.setMsg("产品信息查询成功！");
        resultByPageVO.setDataList(productInfoVOList);
        resultByPageVO.setCurrentNumber(currentNumber);
        resultByPageVO.setCurrentPage(pageWrapper.getNumber() + 1);
        resultByPageVO.setTotalNumber(pageWrapper.getTotalElements());
        return resultByPageVO;
    }


    @RequestMapping("productInfosForOrder")
    public List<ProductInfoCO> getProductInfosByProductIdIn(
            @RequestParam(required = true) List<String> productIdList
    ) {

        List<ProductInfo> productInfoList = productInfoService.findProductInfosByProductIdIn(productIdList);
        List<ProductInfoCO> productInfoCOList = new ArrayList<ProductInfoCO>();
        for (ProductInfo productInfo : productInfoList) {
            ProductInfoCO productInfoCO = new ProductInfoCO();
            BeanUtils.copyProperties(productInfo, productInfoCO);
            productInfoCOList.add(productInfoCO);
        }
        return productInfoCOList;
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        System.out.println(cartDTOList.toString());
        productInfoService.decreseStock(cartDTOList);
    }
}
