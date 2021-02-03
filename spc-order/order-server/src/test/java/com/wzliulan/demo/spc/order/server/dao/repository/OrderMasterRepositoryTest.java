package com.wzliulan.demo.spc.order.server.dao.repository;

import com.wzliulan.demo.spc.order.server.OrderServerApplicationTests;
import com.wzliulan.demo.spc.order.server.dao.model.OrderMaster;
import com.wzliulan.demo.spc.order.server.dao.repository.OrderMasterRepository;
import com.wzliulan.demo.spc.order.server.enums.OrderStatusEnum;
import com.wzliulan.demo.spc.order.server.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
class OrderMasterRepositoryTest extends OrderServerApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    void testSave() {
        OrderMaster orderMaster = OrderMaster.builder()
                .orderId(UUID.randomUUID().toString())
                .orderAmount(new BigDecimal(99.8))
                .orderStatus(OrderStatusEnum.NEW.getCode())
                .payStatus(PayStatusEnum.NEW.getCode())
                .buyerOpenid("wechat-" + UUID.randomUUID().toString())
                .buyerName("张三")
                .buyerPhone("13802780104")
                .buyerAddress("广州，天河区")
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        OrderMaster result = orderMasterRepository.save(orderMaster);
        if (null != result) {
            log.info("订单创建结果：orderMaster={}",result.toString());
        }
    }
}