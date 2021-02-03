package com.wzliulan.demo.spc.goods.server.dao.repository;

import com.wzliulan.demo.spc.goods.server.dao.model.ProductInfo;
import com.wzliulan.demo.spc.goods.server.dao.repository.ProductInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    void findByProductStatus() {
        List<ProductInfo> products = null;
        try {
            products = productInfoRepository.findByProductStatus(1);
            log.info("当前上架的商品总数={}", products.size());
            //  Assert.isTrue(products.size()>0, "products.size()=" + products.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findByProductIdIn() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "203103465734242996"));
        log.info("商品总数={}", productInfoList.size());
    }

}