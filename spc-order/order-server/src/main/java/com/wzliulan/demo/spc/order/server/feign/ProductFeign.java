package com.wzliulan.demo.spc.order.server.feign;//package com.wzliulan.demo.spc.order.feign;
//
//import com.wzliulan.demo.spc.order.dto.CartDto;
//import com.wzliulan.demo.spc.order.vo.ProductVo;
//import com.wzliulan.demo.spc.order.vo.ResultVo;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@FeignClient(name = "SPC-GOODS", contextId = "spc-goods-client-002")
//public interface ProductFeign {
//    /**
//     * 查询类目下的所有上架商品
//     * @return
//     */
//    @GetMapping("/spc-goods/product/search/category/product")
//    ResultVo searchGoods();
//
//    /**
//     * 查询下单所需的商品数据
//     * @param productIdList
//     * @return
//     */
//    @PostMapping("/spc-goods/product/order-products")
//    List<ProductVo> queryProducts(@RequestBody List<String> productIdList);
//
//    /**
//     * 处理下单扣库存
//     * @param cartDtoList
//     * @return
//     */
//    @PostMapping("/spc-goods/product/decrease")
//    ResultVo decrease(@RequestBody List<CartDto> cartDtoList);
//}
