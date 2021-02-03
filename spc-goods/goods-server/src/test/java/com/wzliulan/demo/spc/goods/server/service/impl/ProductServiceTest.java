package com.wzliulan.demo.spc.goods.server.service.impl;

import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.goods.server.dao.model.ProductInfo;
import com.wzliulan.demo.spc.goods.server.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private IProductService productService;

    @Test
    void findUpAll() {
        try {
            List<ProductInfo> productInfoList = productService.findUpAll();
            log.info("当前上架的商品总数={}", productInfoList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findProductList() {
        try {
            List<ProductInfoOutput> productInfoList = productService.findProductList(Arrays.asList("157875196366160022", "203103465734242996"));
            log.info("当前商品总数={}", productInfoList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void decreaseStock() {
        DecreaseInput decreaseInput = DecreaseInput.builder()
                .productId("157875196366160022")
                .productQuantity(2)
                .build();
        List<DecreaseInput> decreaseInputList = new ArrayList<>();
        decreaseInputList.add(decreaseInput);
        productService.decreaseStock(decreaseInputList);
    }
}