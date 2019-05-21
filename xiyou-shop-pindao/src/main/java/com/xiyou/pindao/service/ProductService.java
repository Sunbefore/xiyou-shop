package com.xiyou.pindao.service;

import com.xiyou.common.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
