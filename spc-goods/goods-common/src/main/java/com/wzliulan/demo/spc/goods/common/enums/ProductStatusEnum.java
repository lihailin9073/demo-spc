package com.wzliulan.demo.spc.goods.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架");
    private Integer code;
    private String desc;
}
