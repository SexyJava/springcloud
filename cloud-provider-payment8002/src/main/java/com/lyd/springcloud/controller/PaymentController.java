package com.lyd.springcloud.controller;

import com.lyd.springcloud.entities.CommonResult;
import com.lyd.springcloud.entities.Payment;
import com.lyd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: springcloud
 * @description: 请求控制器
 * @author: CodeLiu
 * @create: 2020-07-29 22:07
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("---插入条数："+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverport:"+serverPort,result);
        }else {
            return new CommonResult(400,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("---查询结果："+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverport"+serverPort,payment);
        }else {
            return new CommonResult(400,"没有对应记录，查询Id："+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
