package com.example.demo1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("/info/{msg}")
    public String sayHello(@PathVariable("msg") String msg){
        return msg;
    }
}
