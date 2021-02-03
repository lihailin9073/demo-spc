package com.wzliulan.demo.spc.order.server.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.wzliulan.demo.spc.order.server.dao.model.OrderDetail;
import com.wzliulan.demo.spc.order.server.dto.OrderDto;
import com.wzliulan.demo.spc.order.server.enums.ResultEnum;
import com.wzliulan.demo.spc.order.server.exception.OrderException;
import com.wzliulan.demo.spc.order.server.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDtoConverter {

    public static OrderDto convert(OrderForm orderForm) {
        OrderDto orderDto = OrderDto.builder()
                .buyerName(orderForm.getName())
                .buyerPhone(orderForm.getPhone())
                .buyerAddress(orderForm.getAddress())
                .buyerOpenid(orderForm.getOpenid())
                .build();

        List<OrderDetail> orderDetailList = new ArrayList<>();
        Gson gson = new Gson();
        try {
            orderDetailList = gson.fromJson(
                    orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType()
            );
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            log.error("[gson转换]错误，string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;
    }
}
