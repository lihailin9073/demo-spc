package com.wzliulan.demo.spc.order.server.rabbitmq.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wzliulan.demo.spc.goods.common.domain.ProductInfoOutput;
import com.wzliulan.demo.spc.order.server.utils.JsonUtil;
import io.lettuce.core.RedisException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Component
public class ProductInfoReceiver {
    /**
     * 商品库存Redis键名模板
     */
    private static final String PRODUCT_STOCK_TEMPLATE = "spc:order:product_stock_%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 订阅商品库存消息
     * @param productMessage
     */
    @RabbitListener(queuesToDeclare = @Queue("spc.order"))
    public void process(String productMessage) {
        log.info("收到队列 [spc.order] 的消息：{}", productMessage);
        // 监听最新的库存信息
        List<ProductInfoOutput> productInfoOutputList = null;
        try {
            productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(productMessage, new TypeReference<List<ProductInfoOutput>>() {});
            // 推送最新的库存信息到Redis
            for (ProductInfoOutput output : productInfoOutputList) {
                String key = null;
                Integer value = null;
                try {
                    key = String.format(PRODUCT_STOCK_TEMPLATE, output.getProductId());
                    value = output.getProductStock();
                    stringRedisTemplate.opsForValue().set(key, value.toString());
                } catch (RedisException redisException) {
                    redisException.printStackTrace();
                    throw redisException;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
