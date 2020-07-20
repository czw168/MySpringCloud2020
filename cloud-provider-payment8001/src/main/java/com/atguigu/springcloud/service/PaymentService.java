package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public CommonResult create(Payment payment);

    public CommonResult getPaymentById(@Param("id")Long id);
}
