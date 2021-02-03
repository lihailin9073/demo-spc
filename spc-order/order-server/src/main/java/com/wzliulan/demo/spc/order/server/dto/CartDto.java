package com.wzliulan.demo.spc.order.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {
    private String productId; // 商品ID
    private Integer productQuantity; // 商品数量
}