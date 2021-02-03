package com.wzliulan.demo.spc.order.server.vo;

import lombok.Data;

@Data
public class ResultVo<T> {
    private Integer code; // 错误码
    private String message; // 提示信息
    private T data; // 业务数据
}
