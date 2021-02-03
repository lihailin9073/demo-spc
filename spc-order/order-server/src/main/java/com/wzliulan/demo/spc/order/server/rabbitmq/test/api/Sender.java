package com.wzliulan.demo.spc.order.server.rabbitmq.test.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        amqpTemplate.convertAndSend("my-queue3", "当前时间 = " + new Date());

        // 发送数码订单
        amqpTemplate.convertAndSend("order.exchange", "3c", "这是数码订单，当前时间 = " + new Date());
        // 发送水果订单
        amqpTemplate.convertAndSend("order.exchange", "fruit", "这是水果订单，当前时间 = " + new Date());
    }
}
