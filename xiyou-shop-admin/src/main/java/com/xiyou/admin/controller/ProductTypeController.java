package com.xiyou.admin.controller;

import com.xiyou.admin.service.ProductTypeService;
import com.xiyou.common.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 查询所有的productType，查询所有的商品类型，该页面用于展示产品类型
     * @return
     */
    @GetMapping(value = "/listAllProductType")
    public String listAllProductType(Model model){
        List<ProductType> list = productTypeService.listAllProductType();
        model.addAttribute("productTypeList", list);
        System.out.println(list);
        return "listtype";
    }

    /**
     * 查询所有的商品类型 更上面的方法基本一致，跳转到不同的页面, 该页面用于对产品类型的操作
     * @param model
     * @return
     */
    @GetMapping("/listProductTypeByProduct")
    public String listProductTypeByProduct(Model model){
        List<ProductType> list = productTypeService.listAllProductType();
        model.addAttribute("productTypeList", list);
        System.out.println(list);
        return "listtypebypr";
    }
}
