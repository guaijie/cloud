package com.example.product.controller;

import com.example.product.VO.ProductInfoVO;
import com.example.product.VO.ProductVO;
import com.example.product.VO.ResultVO;
import com.example.product.entity.Category;
import com.example.product.entity.ProductInfo;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    private final Integer COUNTS=10;

    private final Integer PAGES=1;

    /*
    * 根据类目和状态分页获取产品信息
    * */
    @RequestMapping("productInfos")
    public ResultVO getALlProductInfo(
            @RequestParam(required=false) Integer status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) Integer counts
    ){
        Page<ProductInfo> pageWrapper;

        if(pages==null || pages.toString().equals("")){
            pages=PAGES;
        }
        if(counts==null || counts.toString().equals("")){
            counts=COUNTS;
        }
        pages=pages-1;


        if((status==null || status.toString().equals("") ) && (type==null || type.equals(""))){
            System.out.println(1);
            pageWrapper=productInfoService.findProductInfosByPages(pages,counts);
        }else if(type==null || type.equals("")){
            System.out.println(2);
            pageWrapper = productInfoService.findProductInfosByStatus(status,pages,counts);
        }else if(status==null || status.toString().equals("")){
            System.out.println(3);
            pageWrapper = productInfoService.findProductInfosByType(type,pages,counts);
        }else{
            System.out.println(4);
            pageWrapper = productInfoService.findProductInfosByTypeAndStatus(type,status,pages,counts);
        }

        //获取产品信息列表
        List<ProductInfo> productInfoList = pageWrapper.getContent();

        //获取类目列表
        List<String> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //获取类目信息
        List<Category> categoryList = categoryService.findCategoriesByCategoryTypes(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<ProductVO>();
        for(Category category:categoryList) {
            ProductVO productVO = new ProductVO();
            List<ProductInfoVO> productInfoVOList = new ArrayList<ProductInfoVO>();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO =new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("产品信息查询成功！");
        resultVO.setData(productVOList);
        return resultVO;
    }


    @RequestMapping("hello")
    public String sayHello(){
       return "hello";
    }

}
