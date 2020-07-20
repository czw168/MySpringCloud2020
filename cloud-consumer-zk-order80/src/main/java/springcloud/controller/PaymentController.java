package springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {

    public static final String PAYMENT_URL = "http://cloud-provider-zk-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getString() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk" , String.class);
    }



}
