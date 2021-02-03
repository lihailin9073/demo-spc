package com.wzliulan.demo.spc.order.server.service.impl;

import com.wzliulan.demo.spc.goods.client.feign.ProductFeign;
import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.order.server.dao.model.OrderDetail;
import com.wzliulan.demo.spc.order.server.dao.model.OrderMaster;
import com.wzliulan.demo.spc.order.server.dao.repository.OrderDetailRepository;
import com.wzliulan.demo.spc.order.server.dao.repository.OrderMasterRepository;
import com.wzliulan.demo.spc.order.server.dto.OrderDto;
import com.wzliulan.demo.spc.order.server.enums.OrderStatusEnum;
import com.wzliulan.demo.spc.order.server.enums.PayStatusEnum;
import com.wzliulan.demo.spc.order.server.service.IOrderService;
import com.wzliulan.demo.spc.order.server.utils.UniqueKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductFeign productFeign;

    @Override
    @Transactional
    public OrderDto create(OrderDto orderDto) {
        // 生成订单号
        String orderId = UniqueKeyUtil.generateUniqueKey();

        // TODO 2、查询商品信息（调用商品微服务）
        List<String> productIdList = orderDto.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> products = productFeign.queryProducts(productIdList);

        // TODO 3、计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            for (ProductInfoOutput productVo : products) {
                if (orderDetail.getProductId().equals(productVo.getProductId())) { // 计算订单总价
                    // 单价 * 商品，并累加多个不同商品的总价
                    orderAmount = productVo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                    // 订单详情入库
                    BeanUtils.copyProperties(productVo, orderDetail); // 注意：这种属性复制的方式，会把 null 值也复制过去
                    orderDetail.setOrderId(orderId); // 订单ID
                    orderDetail.setDetailId(UniqueKeyUtil.generateUniqueKey()); // 主键ID
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // TODO 4、扣库存（调用商品微服务）
        List<DecreaseInput> decreaseInputList = orderDto.getOrderDetailList().stream()
                .map(orderDetail -> new DecreaseInput(orderDetail.getProductId(), orderDetail.getProductQuantity()))
                .collect(Collectors.toList());
        productFeign.decrease(decreaseInputList);

        // 5、订单入库
        OrderMaster orderMaster = OrderMaster.builder().build();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto, orderMaster); // 从入参处，复制已有的数据
        orderMaster.setOrderAmount(orderAmount)
                .setOrderStatus(OrderStatusEnum.NEW.getCode())
                .setPayStatus(PayStatusEnum.NEW.getCode())
                .setCreateTime(new Date()).setUpdateTime(new Date());
        try {
            orderMasterRepository.save(orderMaster);
            return orderDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
