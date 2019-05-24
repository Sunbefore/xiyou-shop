package com.xiyou.admin.service;

import com.xiyou.common.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
     * 添加商品
     * @param product
     * @return
     */
    @RequestMapping(value = "/insertOutProduct", method = RequestMethod.POST)
    public void insertOutProduct(@RequestBody Product product);


    /**
     * 根据id删除某一个产品
     * @param id
     */
    @RequestMapping(value = "deleteOutProduct/{id}", method = RequestMethod.GET)
    public void deleteOutProduct(@PathVariable("id") Integer id);


    /**
     * 根據id查看其产品信息
     * @param id
     * @param
     * @return
     */
    @RequestMapping(value = "/viewOutProduct/{id}", method = RequestMethod.GET)
    public Product viewOutProduct(@PathVariable("id") Integer id);

    /**
     * 更改产品的相关信息
     * @param product
     */
    @RequestMapping(value = "/updateOutProduct", method = RequestMethod.POST)
    public void updateOutProduct(@RequestBody Product product);
}
