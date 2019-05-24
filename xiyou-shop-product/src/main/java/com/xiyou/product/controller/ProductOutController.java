package com.xiyou.product.controller;

import com.xiyou.common.model.Product;
import com.xiyou.product.service.ProductService;
import com.xiyou.product.vo.ConstomProduct;
import com.xiyou.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("/insertOutProduct")
    public void insertProduct(@RequestBody Product product){
        product.setCreatetime(new Date());
        product.setSellnum(0);
        // 默认是上架
        product.setProductstatus(0);
        productService.insertProduct(product);
    }


    /**
     * 根据id删除某一个产品
     * @param id
     */
    @GetMapping("deleteOutProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
    }


    /**
     * 根據id查看其产品信息
     * @param id
     * @param
     * @return
     */
    @GetMapping("/viewOutProduct/{id}")
    public Product viewOutProduct(@PathVariable Integer id){
        Product product = productService.findproductById(id);
        return product;
    }

    /**
     * 更改产品的相关信息
     * @param product
     */
    @PostMapping("/updateOutProduct")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

}
