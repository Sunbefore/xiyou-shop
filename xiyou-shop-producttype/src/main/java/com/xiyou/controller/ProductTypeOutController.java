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

    @GetMapping(value = "/listProductType")
    public List<ProductType> listProductType(){
        List<ProductType> list = productTypeService.listAllProductType();
        return list;
    }
}
