package com.atguigu.springcloud;

import com.atguigu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 订单模块启动类
 * EnableEurekaClient 开启eureka
 * EnableDiscoveryClient 开启服务发现
 *
 * @author zzyy
 * @create 2020/2/17 21:13
 **/
@SpringBootApplication
@EnableEurekaClient
//使用Ribbon负载均很随机规则
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}