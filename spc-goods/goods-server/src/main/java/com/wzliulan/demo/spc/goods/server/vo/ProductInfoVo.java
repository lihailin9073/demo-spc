package com.wzliulan.demo.spc.goods.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoVo {
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName; // 商品名称
    @JsonProperty("price")
    private BigDecimal productPrice;    // 商品单价
    @JsonProperty("desc")
    private String productDescription;  // 商品详情
    @JsonProperty("icon")
    private String productIcon; // 商品小图
}
