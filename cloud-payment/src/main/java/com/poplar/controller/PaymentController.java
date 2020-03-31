package com.poplar.controller;

import com.poplar.domain.Payment;
import com.poplar.domain.Result;
import com.poplar.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Create BY poplar ON 2020/3/28
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        if (result > 0) {
            return Result.success("支付成功", result);
        }
        return Result.fail("失败");
    }

    @GetMapping("/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return Result.success(result);
        }
        return Result.fail("失败");
    }

    @GetMapping(value = "/zookeeper")
    public String getZookeeperInfo(){
        return "springcloud with zookeeper:"+ UUID.randomUUID().toString();
    }
}
