package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @return
     */
    public String OK(){
        return Thread.currentThread().getName() + "---OK";
    }

    /**
     * 模拟超时访问
     * @return
     */
    public String NO(){
        int timeNumber = 3;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Thread.currentThread().getName() + "---NO";
    }

    /**
     * 熔断测试
     * @param id
     * @return
     */
    @HystrixCommand(
            fallbackMethod = "circuitBreakerFallBack",
            commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
            }
    )
    public String circuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t circuitBreaker \t id = " + id + "\t uuid = " + uuid;
    }

    public String circuitBreakerFallBack(Integer id){
        return Thread.currentThread().getName() + "\t circuitBreakerFallBack \t id = " + id;
    }

}
