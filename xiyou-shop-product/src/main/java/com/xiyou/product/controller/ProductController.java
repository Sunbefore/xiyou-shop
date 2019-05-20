package com.xiyou.product.controller;

import com.xiyou.product.model.Product;
import com.xiyou.product.service.ProductService;
import com.xiyou.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

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
        productService.insertProduct(product);
    }

    /**
     * 跳转到管理员审核商品页面
     * 更改其审核时间和审核状态
     * @param
     */
    @GetMapping("/toAuditProduct/{id}")
    public String auditProduct(@PathVariable Integer id, Model model){
        Product product = productService.findproductById(id);
        model.addAttribute("product", product);
        return "auditproduct";
    }
    
    /**
     * 管理员审核商品
     * 更改其审核时间和审核状态
     * @param
     */
    @PostMapping("/auditProduct")
    public void auditProduct(Product product){
        productService.auditProduct(product.getId(), product.getAuditstate());
    }


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


    /**
     * 根據id查看其产品信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/toViewProduct/{id}")
    public String toViewProduct(@PathVariable Integer id, Model model){
        Product product = productService.findproductById(id);
        model.addAttribute("product", product);
        return "viewproduct";
    }


    /**
     * 根据id删除某一个产品
     * @param id
     */
    @GetMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "listProduct";
    }

    /**
     * 跳转到更改信息的界面
     * @param id
     * @return
     */
    @GetMapping("/toUpdateProduct/{id}")
    public String toUpdateProduct(@PathVariable Integer id, Model model){
        Product product = productService.findproductById(id);
        model.addAttribute("product", product);
        return "updateproduct";
    }

    /**
     * 更改产品的相关信息
     * @param product
     */
    @PostMapping("/updateProduct")
    public void updateProduct(Product product){
        productService.updateProduct(product);
    }

    /**
     * 更新商品的上下架
     * @param id 代表商品的id， productstatus代表商品的上下架 0 上架 1 下架
     */
    @GetMapping("/updateProductByProductStatus")
    public void updateProductbyProductStatus(int id, int productStatus){
        productService.updateProductbyProductStatus(id, productStatus);
    }
}
