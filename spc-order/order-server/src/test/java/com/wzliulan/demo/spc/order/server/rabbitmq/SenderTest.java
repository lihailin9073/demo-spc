package com.wzliulan.demo.spc.order.server.rabbitmq;

import com.wzliulan.demo.spc.order.server.OrderServerApplicationTests;
import com.wzliulan.demo.spc.order.server.rabbitmq.test.api.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SenderTest extends OrderServerApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    void send() {
        sender.send();
    }
}