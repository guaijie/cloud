package com.example.server.service;

import com.example.server.entity.Category;

import java.util.List;

public interface CategoryService {

    //找到所有类目信息
    List<Category> findALlCategories();

    //根据类目类型获取类目信息
    List<Category> findCategoriesByCategoryTypes(List<String> categoryTypes);

}

