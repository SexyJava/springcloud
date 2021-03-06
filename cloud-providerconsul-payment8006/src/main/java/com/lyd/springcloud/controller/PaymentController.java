package com.lyd.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Liuyunda
 * @Date 2020/8/6 21:25
 * @Email man021436@163.com
 * @Description: DOTO
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
