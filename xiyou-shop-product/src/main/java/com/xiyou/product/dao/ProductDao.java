package com.xiyou.product.dao;

import com.xiyou.common.model.Product;
import com.xiyou.product.mapper.ProductMapper;
import com.xiyou.product.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
// cacheNames对应的是xml中配置的name属性
@CacheConfig(cacheNames = "productCache")
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加商品
     * @param product
     * @return
     */
    @Cacheable
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
    // 没写key 默认是所有参数作为key
    @Cacheable
    public Product findproductById(int id){
        System.out.println("进入product的查询。。。");
        return productMapper.findproductById(id);
    }

    /**
     * 更改产品
     * @param product
     */
    @CachePut(key = "#id")
    public void updateProduct(Product product){
        productMapper.updateProduct(product);
    }

    /**
     * 根据id删除产品
     * @param id
     */
    // @CacheEvict()
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


    /**
     * 根据ids查询product
     * @param map
     * @return
     */
    public List<Product> queryProductByIds(Map<String, List<String>> map){
        return productMapper.queryProductByIds(map);
    }
}
