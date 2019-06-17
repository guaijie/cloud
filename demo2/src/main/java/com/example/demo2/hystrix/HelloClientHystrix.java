package com.example.demo2.hystrix;

import com.example.demo2.client.HelloClient;
import org.springframework.stereotype.Component;

@Component
public class HelloClientHystrix implements HelloClient {

    @Override
    public String sayHello(String msg) {
        return "请求信息失败！";
    }
}
