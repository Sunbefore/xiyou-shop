package com.xiyou.pindao.controller;

import com.xiyou.common.model.Product;
import com.xiyou.common.model.ProductType;
import com.xiyou.pindao.service.ProductService;
import com.xiyou.pindao.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 根据产品类型找到相关的产品
 */
@Controller
public class IndexController {
    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;

    /**
     * 根据productTypeId查询ProductType
     * @param model
     * @param productTypeId
     * @return
     */
    @GetMapping("/indexProduct/{productTypeId}")
    public String indexProduct(Model model, @PathVariable Integer productTypeId){
        // 查询出所有的产品类型
        List<ProductType> productTypeList = productTypeService.listAllProductType();
        model.addAttribute("productTypeList", productTypeList);
        if(productTypeId == -1){
            // 如果不存在默认将第一个传递进来
            productTypeId = productTypeList.get(0).getId();
        }
        // 根据产品类型id 查询所有的产品
        List<Product> productList = productService.listProductOut(productTypeId);
        model.addAttribute("productList", productList);
        return "list";
    }


    /**
     * 根据关键词 查询product
     * @param keyWord
     * @return
     */
    @PostMapping("/searchProductOut")
    public String searchProductOut(String keyWord, Model model){
        List<Product> productList = productService.searchProductOut(keyWord);
        System.out.println("solr搜索结果：" + productList);
        model.addAttribute("productList", productList);
        return "list";
    }

}
