package com.wzliulan.demo.spc.order.server.rabbitmq.test.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    // @RabbitListener(queues = "my-queue") // 手动创建队列
    // @RabbitListener(queuesToDeclare = @Queue("my-queue2"))// 自动创建队列
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("my-queue3"),
            exchange = @Exchange("my.exchange1")
    )) // 自动创建队列，并绑定交换机
    public void process(String message) {
        log.info("收到的消息：{}", message);
    }

    // 数码应商 接收消息
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("order.exchange"),
            key = "3c",
            value = @Queue("3c-order")
    )) // 自动创建队列，绑定交换机、指定key
    public void process3C(String message) {
        log.info("数码供应商，收到的消息：{}", message);
    }

    // 水果供应商 接收消息
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("order.exchange"),
            key = "fruit",
            value = @Queue("fruit-order")
    )) // 自动创建队列，绑定交换机、指定key
    public void processFruit(String message) {
        log.info("水果供应商，收到的消息：{}", message);
    }

}
