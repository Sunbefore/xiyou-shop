package com.xiyou.pindao.controller;

import com.xiyou.common.model.Product;
import com.xiyou.pindao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 通过productTypeId查询Product
     * @param proudctTypeId
     * @return
     */
    @GetMapping("/listProductOut/{proudctTypeId}")
    public List<Product> listProductOut(@PathVariable("proudctTypeId") Integer proudctTypeId){
        List<Product> productList = productService.listProductOut(proudctTypeId);
        return productList;
    }
}
