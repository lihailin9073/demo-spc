package com.wzliulan.demo.spc.order.server.service;


import com.wzliulan.demo.spc.order.server.dto.OrderDto;

public interface IOrderService {
    OrderDto create(OrderDto orderDto);
}
