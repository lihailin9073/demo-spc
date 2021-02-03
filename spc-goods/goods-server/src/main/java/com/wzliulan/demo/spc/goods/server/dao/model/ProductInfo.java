package com.wzliulan.demo.spc.goods.server.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "product_info") // 表名、类名相同时可以不写，这里就可以不写
public class ProductInfo {
    @Id
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
