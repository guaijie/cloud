package com.example.server.controller;

import com.example.server.entity.Category;
import com.example.server.service.CategoryService;
import com.example.server.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    /*
    * 获取类目信息
    * */
    @RequestMapping("categories")
    public ResultVO getCategories(@RequestParam(required = false) String categoryType){

        List<Category> list;

        if(categoryType==null || categoryType.equals("")){
            list=categoryService.findALlCategories();
        }else{
            list=categoryService.findCategoriesByCategoryTypes(Arrays.asList(categoryType));
        }

        ResultVO resultVO=new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("类目信息查询成功！");
        resultVO.setData(list);

        return resultVO;
    }
}
