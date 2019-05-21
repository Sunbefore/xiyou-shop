package com.xiyou.product.controller;

import com.xiyou.common.model.Product;
import com.xiyou.product.service.ProductService;
import com.xiyou.product.vo.ConstomProduct;
import com.xiyou.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 该controller用于进行feign的调用
 */
@RestController
public class ProductOutController {

    @Autowired
    private ProductService productService;

    /**
     * 根据productTypeId 查询product
     * @param proudctTypeId
     * @return
     */
    @GetMapping("/listProductOut/{proudctTypeId}")
    public List<Product> listproductout(@PathVariable Integer proudctTypeId){
        ConstomProduct constomProduct = new ConstomProduct();
        constomProduct.setProducttypeid(proudctTypeId);
        ProductVo productvo = new ProductVo();
        productvo.setConstomProduct(constomProduct);
        List<Product> list = productService.queryProductByVo(productvo);
        return list;
    }

}
