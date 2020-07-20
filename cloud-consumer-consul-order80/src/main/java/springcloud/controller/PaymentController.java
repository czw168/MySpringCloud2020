package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {

    public static final String PAYMENT_URL = "http://cloud-provider-consul-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String getString() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul" , String.class);
    }



}
