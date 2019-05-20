package com.xiyou.pindao.service;


import com.xiyou.pindao.dao.ProductDao;
import com.xiyou.pindao.model.Product;
import com.xiyou.pindao.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 根据相关属性查询产品
     * @param productVo
     * @return
     */
    public List<Product> queryProductByVo(ProductVo productVo){
        return productDao.queryProductByVo(productVo);
    }
}
