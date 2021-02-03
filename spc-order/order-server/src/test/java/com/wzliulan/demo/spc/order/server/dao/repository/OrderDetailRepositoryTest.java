package com.wzliulan.demo.spc.order.server.dao.repository;

import com.wzliulan.demo.spc.order.server.OrderServerApplicationTests;
import com.wzliulan.demo.spc.order.server.dao.model.OrderDetail;
import com.wzliulan.demo.spc.order.server.dao.repository.OrderDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
class OrderDetailRepositoryTest extends OrderServerApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void testSave() {
        OrderDetail orderDetail = OrderDetail.builder()
                .detailId(UUID.randomUUID().toString())
                .orderId("553c1078-a5b3-4138-8932-f2de10683891")
                .productId("157875196366160022")
                .productName("皮蛋瘦肉粥")
                .productPrice(new BigDecimal(3.5))
                .productIcon("http://www.baidu.com/logo.jpg")
                .productQuantity(2)
                .build();

        OrderDetail result = orderDetailRepository.save(orderDetail);
        if (null != result) {
            log.info("订单创建结果：orderDetail={}",result.toString());
        }
    }
}