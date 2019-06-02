package com.example.demo.config;

import com.example.demo.entity.Aliyun;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class AliyunConfig {

    @Value("${appKey}")
    String appKey;

    @Value("${appSecret}")
    String appSecret;

    @Value("${bucket}")
    String bucket;

    @Value("${endPoint}")
    String endPoint;

    @Bean
    public Aliyun aliyun(){
        return Aliyun.options()
                .setAppKey(appKey)
                .setAppSecret(appSecret)
                .setBucket(bucket)
                .setEndPoint(endPoint)
                .build();
    }
}
