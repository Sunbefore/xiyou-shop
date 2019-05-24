package com.xiyou.product.service;

import com.xiyou.common.model.ProductDetail;
import com.xiyou.product.dao.ProductDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailDao productDetailDao;

    /**
     * 插入产品详情界面
     * @param productDetail
     * @return
     */
    public int insertProductDetail(ProductDetail productDetail){
        return productDetailDao.insertProductDetail(productDetail);
    }

    /**
     * 根据productId查询出产品详情
     * @param proudctId
     * @return
     */
    public ProductDetail findProductDetailByProductId(int proudctId){
        return productDetailDao.findProductDetailByProductId(proudctId);
    }
}
