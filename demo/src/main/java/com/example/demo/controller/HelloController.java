package com.example.demo.controller;
import com.example.demo.DemoApplication;
import com.example.demo.config.AliyunConfig;
import com.example.demo.entity.Aliyun;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("aliyun")
public class HelloController {

    @Autowired
    private Aliyun aliyun;

    Map<String,String> map =new HashMap<String,String>();

    @RequestMapping("aliyunConfig")
    String sayHello(){
        map.put("appKey",aliyun.getAppKey());
        map.put("appSecret",aliyun.getAppSecret());
        map.put("bucket",aliyun.getBucket());
        map.put("endPoint",aliyun.getEndPoint());
        return "hello world:" + map;
    }

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }

}
