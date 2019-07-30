package com.example.zuul.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    public String sayHello(@RequestParam String msg) {
        return msg;
    }
}
