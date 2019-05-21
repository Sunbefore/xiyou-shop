package com.xiyou.product.mapper;


import com.xiyou.common.model.Product;
import com.xiyou.product.vo.ProductVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
public interface ProductMapper {
    /**
     * 添加商品
     * @param product
     * @return
     */
    public int insertProduct(Product product);

    /**
     * 管理员审核商品
     * 更改其审核时间和审核状态
     * @param product
     */
    public void auditProduct(Product product);

    /**
     * 根据id查询商品的相关信息
     * @param id
     * @return
     */
    public Product findproductById(int id);

    /**
     * 更改产品
     * @param product
     */
    public void updateProduct(Product product);

    /**
     * 根据id删除产品
     * @param id
     */
    public void deleteProductById(int id);

    /**
     * 根据相关属性查询产品
     * @param productVo
     * @return
     */
    public List<Product> queryProductByVo(ProductVo productVo);

    /**
     * 更新商品的上下架
     * @param product
     */
    public void updateProductbyProductStatus(Product product);

/*    public void auditProduct(Product product);
    public Product findproductById(int id);
    public void updateProduct(Product product);
    public void deleteProductById(int id);
    //public List<Product> queryProductByVo(ProductVo productVo);
    public void updateProductbyProductStatus(Product product);
    public List<Product> queryProductByIds(Map<String, List<String>> map);*/
}
