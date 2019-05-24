package com.xiyou.product.service;

import com.xiyou.common.model.ProductDetail;
import com.xiyou.product.dao.ProductDetailDao;
import com.xiyou.product.utils.SolrUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailDao productDetailDao;

    // solr的客户端，由springboot直接注入
    @Autowired
    private SolrClient solrClient;

    /**
     * 插入产品详情界面
     * @param productDetail
     * @return
     */
    public int insertProductDetail(ProductDetail productDetail){
        int num = productDetailDao.insertProductDetail(productDetail);
        Map<String, Object> mapValue = new HashMap<>();
        mapValue.put("id", productDetail.getProudctid());
        mapValue.put("productdescription", productDetail.getProductdescription());
        try {
            SolrUtil.addIndex2(solrClient, mapValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
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
