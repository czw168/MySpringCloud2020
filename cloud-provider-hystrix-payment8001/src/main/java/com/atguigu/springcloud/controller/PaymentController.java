package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("payment/ok")
    public String OK(){
        return paymentService.OK();
    }

    @RequestMapping("payment/no")
    public String NO(){
        return paymentService.NO();
    }

    /**
     * 熔断测试
     * @param id
     * @return
     */
    @RequestMapping("payment/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        return paymentService.circuitBreaker(id);
    }

}
