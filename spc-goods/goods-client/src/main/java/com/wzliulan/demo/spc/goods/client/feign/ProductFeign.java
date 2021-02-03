package com.wzliulan.demo.spc.goods.client.feign;

import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.goods.common.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "goods-service", contextId = "goods-service-client-001")
public interface ProductFeign {
    /**
     * 查询类目下的所有上架商品
     * @return
     */
    @GetMapping("/spc-goods/product/search/category/product")
    ResultVo searchGoods();

    /**
     * 查询下单所需的商品数据
     * @param productIdList
     * @return
     */
    @PostMapping("/spc-goods/product/order-products")
    List<ProductInfoOutput> queryProducts(@RequestBody List<String> productIdList);

    /**
     * 下单扣库存处理
     * @param decreaseInputList
     * @return
     */
    @PostMapping("/spc-goods/product/decrease")
    ResultVo decrease(@RequestBody List<DecreaseInput> decreaseInputList);
}