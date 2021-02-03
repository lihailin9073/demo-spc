package com.wzliulan.demo.spc.order.server.rabbitmq.test.stream;

import com.wzliulan.demo.spc.order.server.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableBinding(StreamClient.class) // 绑定一个Stream客户端
@Component
public class StreamReceiver {
    @StreamListener(StreamClient.INPUT)
    public void receiveMessage(Object message) {
        log.info("Stream消息接收者：{}", message);
    }

    // 监听订单消息
    @StreamListener(StreamClient.INPUT)
    public void receiveOrderDtoMessage(OrderDto message) {
        log.info("接收到的订单OrderDto数据为：{}", message);
    }

}