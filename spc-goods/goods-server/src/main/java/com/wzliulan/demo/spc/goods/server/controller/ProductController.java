package com.wzliulan.demo.spc.goods.server.controller;

import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.goods.server.dao.model.ProductCategory;
import com.wzliulan.demo.spc.goods.server.dao.model.ProductInfo;
import com.wzliulan.demo.spc.goods.server.service.ICategoryService;
import com.wzliulan.demo.spc.goods.server.service.IProductService;
import com.wzliulan.demo.spc.goods.common.utils.ResultVoUtil;
import com.wzliulan.demo.spc.goods.server.vo.CategoryAndProductVo;
import com.wzliulan.demo.spc.goods.server.vo.ProductInfoVo;
import com.wzliulan.demo.spc.goods.common.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    // 查询类目下所有上架的商品
    @GetMapping("/search/category/product")
    public ResultVo getCategoryAndProducts() {
        try {
            // 查询所有上架的商品
            List<ProductInfo> productInfoList = productService.findUpAll();

            // 获取上架商品的所有类目ID
            List<Integer> categoryTypeList = productInfoList.stream()
                    .map(ProductInfo::getCategoryType)
                    .collect(Collectors.toList());

            // 查询上架商品的类目清单
            List<ProductCategory> categoryList = categoryService.findCategoryByType(categoryTypeList);

            log.info("categoryList类目条数={}", categoryList.size());

            // 构造数据
            List<CategoryAndProductVo> categoryAndProductVoList = new ArrayList<>();
            for (ProductCategory category : categoryList) {
                CategoryAndProductVo categoryAndProductVo = new CategoryAndProductVo();
                categoryAndProductVo.setCategoryName(category.getCategoryName());
                categoryAndProductVo.setCategoryType(category.getCategoryType());
                // 封装类目下的上架商品
                List<ProductInfoVo> productInfoVoList = new ArrayList<>();
                for (ProductInfo productInfo : productInfoList) {
                    if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                        ProductInfoVo productInfoVo = new ProductInfoVo();
                        BeanUtils.copyProperties(productInfo, productInfoVo);
                        productInfoVoList.add(productInfoVo);
                    }
                }
                categoryAndProductVo.setProductInfoVoList(productInfoVoList);
                // 封装响应Data数据
                categoryAndProductVoList.add(categoryAndProductVo);
            }

            // 封装响应数据
            return ResultVoUtil.success(categoryAndProductVoList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVoUtil.error();
        }
    }

    // 查询下订单所需要的商品清单
    @PostMapping("/order-products")
    public List<ProductInfoOutput> orderProduct(@RequestBody List<String> productIdList) {
        List<ProductInfoOutput> productList = productService.findProductList(productIdList);
        return productList;
    }

    // 下单扣库存
    @PostMapping("/decrease")
    public ResultVo decrease(@RequestBody List<DecreaseInput> decreaseInputList) {
        try {
            productService.decreaseStock(decreaseInputList);
            return ResultVoUtil.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVoUtil.error();
        }
    }

    // 测试用：提供给商品服务的 RestTemplate
    @GetMapping("/test-for-rtp")
    public Object testForRestTemplate() {
        String uuid = UUID.randomUUID().toString();
        return "商品服务的测试接口，UUID=" + uuid;
    }
}
