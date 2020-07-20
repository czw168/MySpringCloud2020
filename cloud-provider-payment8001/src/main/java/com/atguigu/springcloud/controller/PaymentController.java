package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // euerka发现服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }


    @GetMapping("payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service->{
            log.info("有什么服务被注册");
            log.info("-----服务名："+service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("这个(CLOUD-PAYMENT-SERVICE)服务有哪些：");
            log.info("-----"+instance.getServiceId()+"\t" + instance.getHost()+"\t"+ instance.getPort()+"\t"+instance.getUri());

        }

        return this.discoveryClient;
    }


}