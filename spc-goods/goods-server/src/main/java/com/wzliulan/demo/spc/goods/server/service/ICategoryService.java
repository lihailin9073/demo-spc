package com.wzliulan.demo.spc.goods.server.service;

import com.wzliulan.demo.spc.goods.server.dao.model.ProductCategory;

import java.util.List;

public interface ICategoryService {
    /**
     * 根据类目编号查找分类
     *
     * @param categoryTypeList 类目编号列表
     * @return
     */
    List<ProductCategory> findCategoryByType(List<Integer> categoryTypeList);
}
