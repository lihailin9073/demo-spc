package com.wzliulan.demo.spc.goods.server.service.impl;

import com.wzliulan.demo.spc.goods.server.dao.model.ProductCategory;
import com.wzliulan.demo.spc.goods.server.dao.repository.ProductCategoryRepository;
import com.wzliulan.demo.spc.goods.server.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findCategoryByType(List<Integer> categoryTypeList) {
        List<ProductCategory> categoryList = productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
        return categoryList;
    }
}
