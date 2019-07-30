package com.example.product.server.repository;

import com.example.product.server.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //查询所有类目
    List<Category> findAll();

    //指定类目类型来查询类目信息
    List<Category> findAllByCategoryTypeIn(List<String> categoryTypes);

}
