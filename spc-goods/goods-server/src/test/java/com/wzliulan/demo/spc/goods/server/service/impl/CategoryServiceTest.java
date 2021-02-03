package com.wzliulan.demo.spc.goods.server.service.impl;

import com.wzliulan.demo.spc.goods.server.dao.model.ProductCategory;
import com.wzliulan.demo.spc.goods.server.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private ICategoryService categoryService;

    @Test
    void findCategoryByType() {
        try {
            List<ProductCategory> categoryList = categoryService.findCategoryByType(Arrays.asList(11, 22));
            log.info("分类categoryList.size={}", categoryList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}