package com.mscloud.controller;

import com.mscloud.entities.CommonResult;
import com.mscloud.entities.Payment;
import com.mscloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private IPaymentService service;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public CommonResult discovery(){
        List<String> services = discoveryClient.getServices();
        return new CommonResult(200,"成功",services.toString());
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = service.create(payment);
        log.info("***插入结果：{}",payment);
        if(i>0){
            return new CommonResult(200,"插入成功",i);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment paymentById = service.getPaymentById(id);
        log.info("***查询结果：{}",paymentById);
        if(paymentById != null){
            return new CommonResult(200,"查询成功",paymentById);
        }else {
            return new CommonResult(444,"没有对应记录，查询id："+id);
        }
    }
}
