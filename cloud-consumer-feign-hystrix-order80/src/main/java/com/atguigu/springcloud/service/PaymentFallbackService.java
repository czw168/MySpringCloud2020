package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String OK() {
        return "OK_FallBack";
    }

    @Override
    public String NO() {
        return "NO_FallBack";
    }
}
