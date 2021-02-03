package com.wzliulan.demo.spc.goods.server.dao.repository;

import com.wzliulan.demo.spc.goods.server.dao.model.ProductCategory;
import com.wzliulan.demo.spc.goods.server.dao.repository.ProductCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = null;
        try {
            ArrayList<Integer> categoryTypeList = new ArrayList<>();
            categoryTypeList.add(11);
            categoryTypeList.add(22);

            categoryList = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
            categoryList = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 22, 33));
            log.info("当前categoryList总数={}", categoryList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}