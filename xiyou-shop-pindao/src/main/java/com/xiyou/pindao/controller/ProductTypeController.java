package com.xiyou.pindao.controller;

import com.xiyou.common.model.ProductType;
import com.xiyou.pindao.service.ProductTypeService;
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
     * 查询所有的productType，查询所有的商品类型
     * @return
     */
    @GetMapping(value = "/listAllProductType")
    public String listAllProductType(Model model){
        List<ProductType> list = productTypeService.listAllProductType();
        model.addAttribute("productTypeList", list);
        System.out.println(list);
        return "list";
    }
}
