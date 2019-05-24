package com.xiyou.product.service;

import com.xiyou.common.model.Product;
import com.xiyou.product.dao.ProductDao;
import com.xiyou.product.utils.SolrUtil;
import com.xiyou.product.vo.ProductSolr;
import com.xiyou.product.vo.ProductVo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    // Solr的客户端对象 springboot自动生成了
    @Autowired
    private SolrClient solrClient;

    /**
     * 添加商品
     * @param product
     * @return
     */
    public int insertProduct(Product product){
        int num = productDao.insertProduct(product);
        // 构建对象 给solr建立索引
        Map<String, Object> mapValue = new HashMap<>();
        // id建立索引
        mapValue.put("id", product.getId());
        // producttitle建立索引
        mapValue.put("producttitle", product.getProducttitle());
        try {
            SolrUtil.addIndex2(solrClient, mapValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
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

    /**
     * 根据关键词查询product
     * @param keyWord
     * @return
     */
    public List<Product> queryProductByIds(String keyWord){
        List<String> ids = null;
        try {
            // 通过solr查询，利用关键字查询出product的id
            ids = SolrUtil.searchqyinfofromsolr(solrClient, keyWord);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ids == null || ids.size() == 0){
            // 表示solr没有查找到
            ids = null;
        }
        Map<String, List<String>> map = new HashMap<>();
        map.put("ids", ids);
        return productDao.queryProductByIds(map);
    }
}
