package com.wzliulan.demo.spc.order.server.rabbitmq.test.stream;

import com.wzliulan.demo.spc.order.server.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@RequestMapping("/stream")
@RestController
public class MessageController {
    @Autowired
    private StreamClient streamClient;

    // 发送文本消息 String
    @GetMapping("/send")
    public Object sendMessage() {
        String message = "这是一个消息，发送时间="+new Date();
        // 发送一条消息
        streamClient.output().send(MessageBuilder.withPayload(message).build());
        return message;
    }

    // 发送对象消息 OrderDto
    @GetMapping("/order-send")
    public Object orderMessage() {
        OrderDto orderDto = OrderDto.builder()
                .orderId(UUID.randomUUID().toString())
                .orderAmount(new BigDecimal(998.99))
                .orderStatus(0)
                .buyerName("马云")
                .buyerAddress("浙江，杭州")
                .build();
        // 发送一条消息
        streamClient.output().send(MessageBuilder.withPayload(orderDto).build());
        return orderDto.toString();
    }
}