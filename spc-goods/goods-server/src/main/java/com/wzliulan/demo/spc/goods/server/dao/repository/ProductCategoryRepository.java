package com.wzliulan.demo.spc.goods.server.dao.repository;

import com.wzliulan.demo.spc.goods.server.dao.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
