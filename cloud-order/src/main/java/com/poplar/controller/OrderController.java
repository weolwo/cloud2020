package com.poplar.controller;

import com.poplar.domain.Payment;
import com.poplar.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Create BY poplar ON 2020/3/28
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public Result create(@RequestBody Payment payment) {
        Result result = restTemplate.postForObject("http://localhost:7001/payment/create", payment, Result.class);
        if (result != null) {
            return Result.success(result);
        }
        return Result.fail("失败");
    }

    @GetMapping("/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Result result = restTemplate.getForObject("http://localhost:7001/payment/" + id, Result.class);
        if (result != null) {
            return Result.success(result);
        }
        return Result.fail("失败");
    }

    @GetMapping("/zookeeper")
    public String getZookeeperInfo() {
        return restTemplate.getForObject("http://cloud-payment/payment/zookeeper", String.class);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    /*如何获取到注册中心上服务列表信息*/
    @GetMapping("/zookeeperInfo")
    public List<ServiceInstance> discoveryClientMember() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment");
        for (ServiceInstance serviceInstance : instances) {
            System.out.println("url:" + serviceInstance.getUri());
        }
        return instances;
    }
}
