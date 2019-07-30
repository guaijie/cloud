package com.example.product.server.controller;

import com.example.product.server.entity.Category;
import com.example.product.server.service.CategoryService;
import com.example.product.server.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Api(tags = "产品类目", value = "CategoryController")
@RestController
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    /*
     * 获取类目信息
     * */
    @ApiOperation(value = "查询类目信息")
    @ApiImplicitParam(paramType = "query", value = "类目类型", name = "categoryType", dataType = "String")
    @GetMapping("categories")
    public ResultVO getCategories(@RequestParam(required = false) String categoryType) {

        List<Category> list;

        if (categoryType == null || categoryType.equals("")) {
            list = categoryService.findALlCategories();
        } else {
            list = categoryService.findCategoriesByCategoryTypes(Arrays.asList(categoryType));
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("类目信息查询成功！");
        resultVO.setData(list);

        return resultVO;
    }
}
