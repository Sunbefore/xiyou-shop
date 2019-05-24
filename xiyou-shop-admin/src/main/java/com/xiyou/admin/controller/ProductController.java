package com.xiyou.admin.controller;

import com.xiyou.admin.service.ProductDetailService;
import com.xiyou.admin.service.ProductService;
import com.xiyou.common.model.Product;
import com.xiyou.common.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    /**
     * 通过productTypeId查询Product
     * @param proudctTypeId
     * @return
     */
    @GetMapping(value = "/listProductOut/{proudctTypeId}")
    public String listProductOut(@PathVariable("proudctTypeId") Integer proudctTypeId, Model model){
        List<Product> productList = productService.listProductOut(proudctTypeId);
        model.addAttribute("productList", productList);
        return "listproduct";
    }


    /**
     * 跳转到新增商品的页面
     * @return
     */
    @GetMapping("/toInsertProduct")
    public String toInsertProduct(){
        return "addproduct";
    }


    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("/insertProduct")
    public void insertProduct(Product product){
        product.setCreatetime(new Date());
        product.setSellnum(0);
        // 默认是上架
        product.setProductstatus(0);
        productService.insertOutProduct(product);
    }


    /**
     * 根据id删除某一个产品
     * @param id
     */
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteOutProduct(id);
        return "listproduct";
    }


    /**
     * 根據id查看其产品信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/toViewProduct/{id}")
    public String toViewProduct(@PathVariable Integer id, Model model){
        Product product = productService.viewOutProduct(id);
        model.addAttribute("product", product);
        return "viewproduct";
    }

    /**
     * 跳转到更改信息的界面
     * @param id
     * @return
     */
    @GetMapping("/toUpdateProduct/{id}")
    public String toUpdateProduct(@PathVariable Integer id, Model model){
        Product product = productService.viewOutProduct(id);
        model.addAttribute("product", product);
        return "updateproduct";
    }

    /**
     * 更改产品的相关信息
     * @param product
     */
    @PostMapping("/updateProduct")
    public void updateProduct(Product product){
        productService.updateOutProduct(product);
    }


    /**
     * 跳转到新增产品信息页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/toAddProductDetail/{id}")
    public String toAddProductDetail(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "addproductdetail";
    }


    /**
     * 新增产品详情
     * @param productDetail
     */
    @PostMapping(value = "/insertProductDetail")
    public void insertProductDetail(ProductDetail productDetail){
        productDetailService.insertProductDetail(productDetail);
    }
}
