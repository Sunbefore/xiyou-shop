package com.xiyou.admin.service;

import com.xiyou.common.model.ProductType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * producttype的远程调用
 */
@FeignClient("xiyou-shop-producttype")
public interface ProductTypeService {

    /**
     * 查询所有的productType，查询所有的商品类型
     * @return
     */
    @RequestMapping(value = "/listAllProductType", method = RequestMethod.GET)
    public List<ProductType> listAllProductType();
}
