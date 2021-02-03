package com.wzliulan.demo.spc.order.server.dto;

import com.wzliulan.demo.spc.order.server.dao.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private String orderId; // 订单编号
    private String buyerName; // 买家名称
    private String buyerPhone; // 买家号码
    private String buyerAddress; // 买家地址
    private String buyerOpenid; // 买家微信openId
    private BigDecimal orderAmount; // 订单总金额
    private Integer orderStatus; // 订单状态：0=新下单
    private Integer payStatus; // 支付状态：0=待支付
    private List<OrderDetail> orderDetailList; // 订单明细清单
}
