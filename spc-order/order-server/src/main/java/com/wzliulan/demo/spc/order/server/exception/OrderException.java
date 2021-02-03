package com.wzliulan.demo.spc.order.server.exception;

import com.wzliulan.demo.spc.order.server.enums.ResultEnum;

public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
    }
}
