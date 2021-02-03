package com.wzliulan.demo.spc.goods.server.service;


import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.goods.server.dao.model.ProductInfo;

import java.util.List;

public interface IProductService {
    /**
     * 查找所有的上架商品
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查找商品列表
     *
     * @return
     */
    List<ProductInfoOutput> findProductList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseInputList
     */
    void decreaseStock(List<DecreaseInput> decreaseInputList);
}
