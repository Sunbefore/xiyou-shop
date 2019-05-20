package com.xiyou.pindao.mapper;

import com.xiyou.pindao.model.Product;
import com.xiyou.pindao.vo.ProductVo;

import java.util.List;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
public interface ProductMapper {
    /**
     * 根据相关属性查询产品
     * @param productVo
     * @return
     */
    public List<Product> queryProductByVo(ProductVo productVo);

}
