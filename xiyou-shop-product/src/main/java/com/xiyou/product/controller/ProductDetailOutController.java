package com.xiyou.product.controller;


import com.xiyou.common.model.ProductDetail;
import com.xiyou.product.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/18 0018.
 * 商品详情的相关操作
 * 用于给Feign使用 对外使用
 */
@RestController
public class ProductDetailOutController {

    @Autowired
    ProductDetailService productDetailService;

    /**
     * 新增产品详情
     * @param productDetail
     */
    @RequestMapping(value = "/insertProductDetail",method = RequestMethod.POST)
    public void insertProductDetail(@RequestBody ProductDetail productDetail){
        productDetailService.insertProductDetail(productDetail);
    }

    /**
     * 根据产品id 查询产品详情
     * @param productId
     * @return
     */
    @RequestMapping(value = "/findProductDetailByProductId",method = RequestMethod.POST)
    public ProductDetail findProductDetailByProductId(@RequestParam int productId){
       return productDetailService.findProductDetailByProductId(productId);
    }

}
