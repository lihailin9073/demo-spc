package com.wzliulan.demo.spc.goods.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInfoOutput {
    private String productId;
    private String productName; // 商品名称
    private BigDecimal productPrice;    // 商品单价
    private Integer productStock;   // 商品库存
    private String productDescription;  // 商品详情
    private String productIcon; // 商品小图
    private Integer productStatus;  // 商品状态：0=正常，1=下架
    private Integer categoryType;   // 类目编号
}
