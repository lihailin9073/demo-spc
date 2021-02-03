package com.wzliulan.demo.spc.order.server.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_master")
public class OrderMaster {
    @Id
    private String orderId; // 订单编号
    private String buyerName; // 买家名称
    private String buyerPhone; // 买家号码
    private String buyerAddress; // 买家地址
    private String buyerOpenid; // 买家微信openId
    private BigDecimal orderAmount; // 订单总金额
    private Integer orderStatus; // 订单状态：0=新下单
    private Integer payStatus; // 支付状态：0=待支付
    private Date createTime; // 创建时间
    private Date updateTime; // 修改时间
}
