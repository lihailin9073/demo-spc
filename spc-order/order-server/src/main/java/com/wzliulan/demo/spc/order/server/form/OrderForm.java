package com.wzliulan.demo.spc.order.server.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "买家姓名不能为空")
    private String name;
    /**
     * 联系号码
     */
    @NotEmpty(message = "联系号码不能为空")
    private String phone;
    /**
     * 收货地址
     */
    @NotEmpty(message = "收货地址不能为空")
    private String address;
    /**
     * 买家微信openid
     */
    @NotEmpty(message = "买家微信openid不能为空")
    private String openid;
    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
