package com.wzliulan.demo.spc.order.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayStatusEnum {
    NEW(0, "待支付"),
    FINISH(1, "已支付");

    private Integer code;
    private String desc;
}
