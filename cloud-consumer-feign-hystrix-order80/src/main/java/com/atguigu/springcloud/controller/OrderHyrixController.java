package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "Default_FallBack")
public class OrderHyrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常操作
     * @return
     */
    @RequestMapping("consumer/payment/ok")
    public String OK(){
        return paymentHystrixService.OK();
    }

    /**
     * 模拟延迟
     * @return
     */
    @RequestMapping("consumer/payment/no")
    public String NO(){
        return paymentHystrixService.NO();
    }

    /**
     * 模拟异常
     * @return
     */
    @HystrixCommand
    @RequestMapping("consumer/payment/no2")
    public String NO2(){
        int i = 10/0;
        return "NO2";
    }

    // 默认fallback
    public String Default_FallBack(){
        return "Default_FallBack";
    }










}
