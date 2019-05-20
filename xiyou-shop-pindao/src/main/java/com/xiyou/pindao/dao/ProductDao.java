package com.xiyou.pindao.dao;


import com.xiyou.pindao.mapper.ProductMapper;
import com.xiyou.pindao.model.Product;
import com.xiyou.pindao.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 根据相关属性查询产品
     * @param productVo
     * @return
     */
    public List<Product> queryProductByVo(ProductVo productVo){
        return productMapper.queryProductByVo(productVo);
    }
}
