package com.lyd.springcloud.controller;

import com.lyd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Liuyunda
 * @Date 2020/9/7 20:28
 * @Email man021436@163.com
 * @Description: DOTO
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("$(server.port)")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_OK(id);
        log.info("***********result："+s);
        return s;
    }
    @GetMapping("/payment/hystrix/timeou/{id}")
    public String paymentInfo_TimeOut(Integer id){
        String s = paymentService.paymentInfo_TimeOut(id);
        log.info("***********result："+s);
        return s;
    }
    /**
     * @Description: 服务熔断
     * @Param: [id]
     * @return: java.lang.String
     * @Author: Liuyunda
     * @Date: 2020/11/15
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result："+result);
        return result;
    }
}
