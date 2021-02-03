package com.wzliulan.demo.spc.order.server.dao.repository;

import com.wzliulan.demo.spc.order.server.dao.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    // 下单接口，只需要调用insert方法，直接使用JpaRepository自带的即可
}
