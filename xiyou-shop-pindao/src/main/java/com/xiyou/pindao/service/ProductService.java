package com.xiyou.pindao.service;

import com.xiyou.common.model.Product;
import com.xiyou.common.model.ProductDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 远程调用product模块
 */
@FeignClient("xiyou-shop-product")
public interface ProductService {

    /**
     * 通过productTypeId查询Product
     * @param proudctTypeId
     * @return
     */
    @RequestMapping(value = "/listProductOut/{proudctTypeId}", method = RequestMethod.GET)
    public List<Product> listProductOut(@PathVariable("proudctTypeId") Integer proudctTypeId);

    /**
     * 根据关键词 查询product
     * @param keyWord
     * @return
     */
    @RequestMapping(value = "/searchProductOut/{keyWord}", method = RequestMethod.GET)
    public List<Product> searchProductOut(@PathVariable("keyWord") String keyWord);

    /**
     * 根據id查看其产品信息
     * @param id
     * @param
     * @return
     */
    @RequestMapping(value = "/viewOutProduct/{id}", method = RequestMethod.GET)
    public Product viewOutProduct(@PathVariable("id") Integer id);

    /**
     * 根据产品id 查询产品详情
     * @param productId
     * @return
     */
    @RequestMapping(value = "/findProductDetailByProductId",method = RequestMethod.POST)
    public ProductDetail findProductDetailByProductId(@RequestParam(value = "productId") Integer productId);
}
