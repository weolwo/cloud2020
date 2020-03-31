package com.poplar.controller;

import com.alibaba.fastjson.JSON;
import com.poplar.domain.Payment;
import com.poplar.tool.UnitTestTool;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Create BY poplar ON 2020/3/28
 */
class OrderControllerTest {

    @Test
    void create() {
        Payment payment = new Payment(null,"20200329141500L");
        String json = JSON.toJSONString(payment);
        String result = UnitTestTool.postForObject("http://localhost/order/create",null, json);
        System.out.println(result);
    }

    @Test
    void getPaymentById() {
        Map<String, Object> params = new HashMap<>(1);
        String result = UnitTestTool.doRequest("http://localhost/order/3",null,params,"GET");
        System.out.println(result);
    }

    @Test
    void getZookeeper() {
        Map<String, Object> params = new HashMap<>(1);
        String result = UnitTestTool.doRequest("http://localhost/order/zookeeper",null,params,"GET");
        System.out.println(result);
    }

    @Test
    void getZookeeperInfo() {
        Map<String, Object> params = new HashMap<>(1);
        String result = UnitTestTool.doRequest("http://localhost/order/zookeeperInfo",null,params,"GET");
        System.out.println(result);
    }
}