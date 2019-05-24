package com.xiyou.product.dao;

import com.xiyou.common.model.ProductDetail;
import com.xiyou.product.mapper.ProductDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailDao {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    /**
     * 插入产品详情界面
     * @param productDetail
     * @return
     */
    public int insertProductDetail(ProductDetail productDetail){
        return productDetailMapper.insertProductDetail(productDetail);
    }

    /**
     * 根据productId查询出产品详情
     * @param proudctId
     * @return
     */
    public ProductDetail findProductDetailByProductId(int proudctId){
        return productDetailMapper.findProductDetailByProductId(proudctId);
    }
}
