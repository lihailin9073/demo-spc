package com.wzliulan.demo.spc.order.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    PARAM_ERROR(-1000, "参数错误"),
    CART_EMPTY(-1100, "购物车为空"),
    ;

    private Integer code;
    private String desc;
}
