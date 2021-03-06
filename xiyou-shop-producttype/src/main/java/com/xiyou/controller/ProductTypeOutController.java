package com.xiyou.controller;

import com.xiyou.common.model.ProductType;
import com.xiyou.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 负责支撑feign调用的
 */
@RestController
public class ProductTypeOutController {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 查询所有的productType，查询所有的商品类型
     * @return
     */
    @GetMapping(value = "/listAllProductType")
    public List<ProductType> listAllProductType(){
        List<ProductType> list = productTypeService.listAllProductType();
        return list;
    }
}
