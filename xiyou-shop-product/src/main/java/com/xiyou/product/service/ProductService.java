package com.xiyou.product.service;

import com.xiyou.common.model.Product;
import com.xiyou.product.dao.ProductDao;
import com.xiyou.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 添加商品
     * @param product
     * @return
     */
    public int insertProduct(Product product){
        return productDao.insertProduct(product);
    }

    /**
     * 管理员审核商品
     * 更改其审核时间和审核状态
     * @param
     */
    public void auditProduct(int id, int auditstate){
        Product product = new Product();
        product.setId(id);
        product.setAuditstate(auditstate);
        product.setAudittime(new Date());
        productDao.auditProduct(product);
    }

    /**
     * 根据id查询商品的相关信息
     * @param id
     * @return
     */
    public Product findproductById(int id){
        return productDao.findproductById(id);
    }

    /**
     * 更改产品
     * @param product
     */
    public void updateProduct(Product product){
        productDao.updateProduct(product);
    }

    /**
     * 根据id删除产品
     * @param id
     */
    public void deleteProductById(int id){
        productDao.deleteProductById(id);
    }

    /**
     * 根据相关属性查询产品
     * @param productVo
     * @return
     */
    public List<Product> queryProductByVo(ProductVo productVo){
        return productDao.queryProductByVo(productVo);
    }

    /**
     * 更新商品的上下架
     * @param
     */
    public void updateProductbyProductStatus(int id, int productstataus){
        Product product = new Product();
        product.setId(id);
        product.setProductstatus(productstataus);
        productDao.updateProductbyProductStatus(product);
    }
}
