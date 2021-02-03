package com.wzliulan.demo.spc.goods.server.dao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "product_category") // 表名、类名相同时可以不写，这里就可以不写
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName; // 类目名称
    private Integer categoryType; // 类目编号
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}
