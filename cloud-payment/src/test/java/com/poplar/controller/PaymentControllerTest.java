package com.poplar.controller;

import com.alibaba.fastjson.JSON;
import com.poplar.domain.Payment;
import com.poplar.tool.UnitTestTool;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Create BY poplar ON 2020/3/28
 */
class PaymentControllerTest {

    @Test
    void create() {
        Payment payment = new Payment(null,"202003291415L");
        String json = JSON.toJSONString(payment);
        String result = UnitTestTool.doRequest2("http://localhost:7001/payment/create",null, json);
        System.out.println(result);
    }

    @Test
    void getPaymentById() {
        Map<String, Object> params = new HashMap<>(1);
        String result = UnitTestTool.doRequest1("http://localhost:7001/payment/3",null,params,"GET");
        System.out.println(result);
    }

    @Test
    void getZookeeperInfo(){
        Map<String, Object> params = new HashMap<>(1);
        String result = UnitTestTool.doRequest1("http://localhost:7001/payment/zookeeper",null,params,"GET");
        System.out.println(result);
    }

    public static void main(String[] args) {
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime);//2020-03-30T21:58:39.901+08:00[Asia/Shanghai]
    }
}