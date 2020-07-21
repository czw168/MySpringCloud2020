package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    CommonResult<Payment> create(Payment payment);

    CommonResult<Payment> getPaymentById(@Param("id")Long id);
}
