package com.wzliulan.demo.spc.goods.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    PRODUCT_NOT_EXISTS(1, "商品不存在"),
    PRODUCT_STOCK_NOT_ENOUGH(2, "库存不足");
    private Integer code;
    private String desc;
}
