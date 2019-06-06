package com.example.order.controller;

import com.example.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("order")
@Slf4j
public class ClientController {

    @Autowired(required = false)
    private ProductClient productClient;

    @RequestMapping("msg")
    public String hello(){

        String msg=productClient.productSayHello();
        log.info(msg);
        return msg;
    }
}
