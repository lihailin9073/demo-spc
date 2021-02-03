package com.wzliulan.demo.spc.order.server.rabbitmq.test.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    String INPUT = "stream-message";
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    String OUTPUT = "stream-message";
    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}