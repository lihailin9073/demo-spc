package com.wzliulan.demo.spc.order.server.controller;

import com.wzliulan.demo.spc.goods.client.feign.ProductFeign;
import com.wzliulan.demo.spc.goods.common.domain.DecreaseInput;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.goods.common.vo.ResultVo;
import com.wzliulan.demo.spc.order.server.converter.OrderForm2OrderDtoConverter;
import com.wzliulan.demo.spc.order.server.dto.OrderDto;
import com.wzliulan.demo.spc.order.server.enums.ResultEnum;
import com.wzliulan.demo.spc.order.server.exception.OrderException;
import com.wzliulan.demo.spc.order.server.form.OrderForm;
import com.wzliulan.demo.spc.order.server.service.IOrderService;
import com.wzliulan.demo.spc.order.server.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     * 核心业务流程：
     *  1、参数校验
     *  2、查询商品信息（调用商品微服务）
     *  3、计算总价
     *  4、扣库存（调用商品微服务）
     *  5、订单入库
     *
     */
    @PostMapping("/create")
    public Object create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        // 校验入参
        if (bindingResult.hasErrors()) {
            log.info("订单创建：参数不正确；orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        // 转换入参对象为目标对象OrderDto
        OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.error("[创建订单]-->购物车信息为空！");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        // 创建订单
        OrderDto result = orderService.create(orderDto);

        // 响应结果
        Map<String, String> data = new HashMap<>();
        data.put("order_id", result.getOrderId());
        return ResultVoUtil.success(data);
    }

    /**
     * -------------------- 测试 --------------------
     */
    // 测试：Feign的基本使用
    @Autowired
    private ProductFeign productFeign;
    @GetMapping("/search-goods")
    public Object searchGoods() {
        ResultVo resultVo = productFeign.searchGoods();
        return resultVo;
    }
    // 测试：获取下单所需的商品信息
    // @Autowired // 注意：在方法头上加自动注入的注解，Spring容器启动时就会将它执行，从而导致方法体中Feign远程调用被触发
    @GetMapping("/order-products")
    public Object queryProducts() {
        List<ProductInfoOutput> productVoList = productFeign.queryProducts(Arrays.asList("157875196366160022", "203103465734242996"));
        return productVoList;
    }
    // 测试：下单的扣库存动作
    // @Autowired // 注意：在方法头上加自动注入的注解，Spring容器启动时就会将它执行，从而导致方法体中Feign远程调用被触发
    @GetMapping("/order-decrease")
    public Object decrease() {
        DecreaseInput decreaseInput = DecreaseInput.builder()
                .productId("157875196366160022")
                .productQuantity(3)
                .build();
        List<DecreaseInput> decreaseInputList = new ArrayList<>();
        decreaseInputList.add(decreaseInput);

        ResultVo resultVo = productFeign.decrease(decreaseInputList);
        if (200 == resultVo.getCode()) {
            return ResultVoUtil.success(null);
        } else {
            return ResultVoUtil.error();
        }
    }
    /**
     * -------------------- 测试 --------------------
     */

}
