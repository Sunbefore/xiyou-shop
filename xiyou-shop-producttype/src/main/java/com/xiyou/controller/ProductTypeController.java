package com.xiyou.controller;

import com.xiyou.common.model.ProductType;
import com.xiyou.service.ProductTypeService;
import com.xiyou.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 新增产品类型, 因为是<selectKey>标签所以id默认回写到形参中
     * @param productType
     */
    @PostMapping(value = "/insertProductType")
    public void insertProductType(ProductType productType){
        productTypeService.insertProductType(productType);
    }

    /**
     * 根据id查找产品
     * @param id
     * @return
     */
    @GetMapping(value = "/findProductTypeById/{id}")
    public String findProductTypeById(@PathVariable(value = "id") Integer id, Model model){
        ProductType productType = productTypeService.findProductTypeById(id);
        ProductType parentProductType = parentProductType = productTypeService.findProductTypeById(productType.getParentid());
        if(parentProductType == null){
            parentProductType = new ProductType();
            parentProductType.setProducttypename("无");
            parentProductType.setId(-1);
        }
        // 如果没有显示无
        model.addAttribute("productType", productType);
        model.addAttribute("parentProductType", parentProductType);
        // 显示界面
        return "producttypeview";
    }


    /**
     * 跳转到更新产品类型页面,根据id显示对应的信息
     * @param
     */
    @GetMapping("/toUpdateProductTypeById/{id}")
    public String toUpdateProductTypeById(@PathVariable Integer id, Model model){
        ProductType productType = productTypeService.findProductTypeById(id);
        model.addAttribute("productType", productType);
        return "producttypeupdate";
    }

    /**
     * 更新产品类型
     * @param productType
     */
    @PostMapping("/updateProductTypeById")
    public void updateProductTypeById(ProductType productType){
        productTypeService.updateProductTypeById(productType);
    }

    /**
     * 根据id查询记录，进行查看
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/toAddProductTypeById/{id}")
    public String toAddProductTypeById(@PathVariable Integer id, Model model){
        ProductType productType = productTypeService.findProductTypeById(id);
        // 没有找到
        if(productType == null){
            // 如果是空 添加默认
            // 跳转到添加页面，添加页面的productType的id对应着父ID即parentId
            // 所以就是如果为空 跳转到添加页面，此时parentID已经赋值完成，就是-1，否则就是查找到的这个id
            productType = new ProductType();
            productType.setId(-1);
        }
        model.addAttribute("productType", productType);
        return "producttypeadd";
    }

    /**
     * 根据ProdyctTypeVo查询ProductType的信息
     * @param productTypeVo
     * @return
     */
    @GetMapping("/listProductType")
    public String listProductType(ProductTypeVo productTypeVo, Model model){
        List<ProductType> productTypeList = productTypeService.queryListByVo(productTypeVo);
        model.addAttribute("productTypeList", productTypeList);
        return "producttypelist";
    }

    /**
     * 根据id删除对象
     * @param id
     */
    @GetMapping("/deleteProductTypeById/{id}")
    public void deleteProductTypeById(@PathVariable int id){
        productTypeService.deleteProductTypeById(id);
    }
}
