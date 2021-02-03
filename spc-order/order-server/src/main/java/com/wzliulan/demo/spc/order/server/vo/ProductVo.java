package com.wzliulan.demo.spc.order.server.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductVo {
    private String productId;
    private String productName; // 商品名称
    private BigDecimal productPrice;    // 商品单价
    private Integer productStock;   // 商品库存
    private String productDescription;  // 商品详情
    private String productIcon; // 商品小图
    private Integer productStatus;  // 商品状态：0=正常，1=下架
    private Integer categoryType;   // 类目编号
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}