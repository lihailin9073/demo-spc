package com.wzliulan.demo.spc.goods.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DecreaseInput {
    private String productId; // 商品ID
    private Integer productQuantity; // 商品数量
}
