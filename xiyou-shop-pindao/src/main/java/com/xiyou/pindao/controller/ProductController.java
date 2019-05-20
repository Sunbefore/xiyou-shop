package com.xiyou.pindao.controller;

import com.xiyou.pindao.model.Product;
import com.xiyou.pindao.service.ProductService;
import com.xiyou.pindao.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 跳转到查询列表,里面有增删等相关操作
     * @return
     */
    @GetMapping("/toListProduct")
    public String toListProduct(Model model){
        ProductVo productVo = new ProductVo();
        List<Product> list = productService.queryProductByVo(productVo);
        model.addAttribute("list", list);
        return "listProduct";
    }
}
