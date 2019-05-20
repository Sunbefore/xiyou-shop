package com.xiyou.product.dao;

import com.xiyou.product.mapper.ProductMapper;
import com.xiyou.product.model.Product;
import com.xiyou.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加商品
     * @param product
     * @return
     */
    public int insertProduct(Product product){
        return productMapper.insertProduct(product);
    }

    /**
     * 管理员审核商品
     * 更改其审核时间和审核状态
     * @param product
     */
    public void auditProduct(Product product){
        productMapper.auditProduct(product);
    }

    /**
     * 根据id查询商品的相关信息
     * @param id
     * @return
     */
    public Product findproductById(int id){
        return productMapper.findproductById(id);
    }

    /**
     * 更改产品
     * @param product
     */
    public void updateProduct(Product product){
        productMapper.updateProduct(product);
    }

    /**
     * 根据id删除产品
     * @param id
     */
    public void deleteProductById(int id){
        productMapper.deleteProductById(id);
    }

    /**
     * 根据相关属性查询产品
     * @param productVo
     * @return
     */
    public List<Product> queryProductByVo(ProductVo productVo){
        return productMapper.queryProductByVo(productVo);
    }

    /**
     * 更新商品的上下架
     * @param product
     */
    public void updateProductbyProductStatus(Product product){
        productMapper.updateProductbyProductStatus(product);
    }
}
