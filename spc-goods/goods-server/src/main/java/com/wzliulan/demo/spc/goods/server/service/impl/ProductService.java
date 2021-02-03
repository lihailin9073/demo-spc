package com.wzliulan.demo.spc.goods.server.service.impl;

import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.goods.server.dao.model.ProductInfo;
import com.wzliulan.demo.spc.goods.server.dao.repository.ProductInfoRepository;
import com.wzliulan.demo.spc.goods.common.enums.ProductStatusEnum;
import com.wzliulan.demo.spc.goods.common.enums.ResultEnum;
import com.wzliulan.demo.spc.goods.server.exception.ProductException;
import com.wzliulan.demo.spc.goods.server.service.IProductService;
import com.wzliulan.demo.spc.goods.server.utils.JsonUtil;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfoOutput> findProductList(List<String> productIdList) {
        // 查询数据
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(productIdList);
        // 转换数据
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream()
                .map(productInfo -> {
                    ProductInfoOutput output = ProductInfoOutput.builder().build();
                    BeanUtils.copyProperties(productInfo, output);
                    return output;
                })
                .collect(Collectors.toList());
        return productInfoOutputList;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoList;
    }

    @Override
    public void decreaseStock(List<DecreaseInput> decreaseInputList) {
        // 更新数据库中商品的库存
        List<ProductInfo> productInfoList = this.updateStock(decreaseInputList);
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream()
                .map(e -> {
                    ProductInfoOutput output = ProductInfoOutput.builder().build();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());

        // TODO 其实，更新数据库的库存后没有必要发布消息到MQ，直接把最新的库存推送到Redis就好了...

        // 发布库存到RabbitMQ
        amqpTemplate.convertAndSend("spc.order", JsonUtil.toJson(productInfoOutputList));
    }

    /**
     * 更新数据库的商品库存
     * @param decreaseInputList 库存数据更新对象
     * @return 返回被更新了库存的商品清单
     */
    @Transactional
    protected List<ProductInfo> updateStock(List<DecreaseInput> decreaseInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseInput decreaseInput : decreaseInputList) {
            Optional<ProductInfo> optional = productInfoRepository.findById(decreaseInput.getProductId());
            if (!optional.isPresent()) { // 商品不存在
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXISTS);
            }
            // 校验库存
            ProductInfo productInfo = optional.get();
            Integer res = productInfo.getProductStock() - decreaseInput.getProductQuantity();
            if (res < 0) { // 库存不足
                throw new ProductException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }
            try {
                // 更新库存
                productInfo.setProductStock(res);
                productInfoRepository.save(productInfo);
            } catch (AmqpException e) {
                e.printStackTrace();
                throw e;
            }
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
