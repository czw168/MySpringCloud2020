package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.MyMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyMessageProviderController {

    @Autowired
    private MyMessageProvider myMessageProvider;

    @GetMapping("send")
    public String send(){
        return myMessageProvider.send();
    }

}
