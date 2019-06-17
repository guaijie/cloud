package com.example.demo2.controller;

import com.example.demo2.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired

    private HelloClient helloClient;

    @RequestMapping("/info/{msg}")
    public String sayHello(@PathVariable("msg") String msg){
        String message = helloClient.sayHello(msg);
        return message;
    }
}

