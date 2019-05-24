package com.xiyou.product.mapper;


import com.xiyou.common.model.ProductDetail;


/**
 * Created by Administrator on 2018/6/18 0018.
 */
public interface ProductDetailMapper {

    /**
     * 插入产品详情界面
     * @param productDetail
     * @return
     */
    public int insertProductDetail(ProductDetail productDetail);

    /**
     * 根据productId查询出产品详情
     * @param proudctId
     * @return
     */
    public ProductDetail findProductDetailByProductId(int proudctId);
}
