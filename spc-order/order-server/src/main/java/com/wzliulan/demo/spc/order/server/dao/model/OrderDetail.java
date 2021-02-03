package com.wzliulan.demo.spc.order.server.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId; // 订单编号
    private String productId; // 商品编号
    private String productName; // 商品名称
    private BigDecimal productPrice; // 商品单价
    private Integer productQuantity; // 商品数量
    private String productIcon; // 商品小图
}
