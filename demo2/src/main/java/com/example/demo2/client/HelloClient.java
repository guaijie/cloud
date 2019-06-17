package com.example.demo2.client;

import com.example.demo2.hystrix.HelloClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="demo1",fallback = HelloClientHystrix.class)
public interface HelloClient {

    @RequestMapping("/hello/info/{msg}")
    String sayHello(@PathVariable("msg") String msg);
}
