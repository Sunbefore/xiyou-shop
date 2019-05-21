package com.xiyou.dao;

import com.xiyou.common.model.ProductType;
import com.xiyou.mapper.ProductTypeMapper;
import com.xiyou.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTypeDao {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 新增产品类型, 因为是<selectKey>标签所以id默认回写到形参中
     * @param productType
     */
    public void insertProductType(ProductType productType){
        productTypeMapper.insertProductType(productType);
    }

    /**
     * 根据id查找产品
     * @param id
     * @return
     */
    public ProductType findProductTypeById(int id){
        return productTypeMapper.findProductTypeById(id);
    }

    /**
     * 更新产品类型
     * @param productType
     */
    public void updateProductTypeById(ProductType productType){
        productTypeMapper.updateProductTypeById(productType);
    }

    /**
     * 根据ProdyctTypeVo查询ProductType的信息
     * @param productTypeVo
     * @return
     */
    public List<ProductType> queryListByVo(ProductTypeVo productTypeVo){
        return productTypeMapper.queryListByVo(productTypeVo);
    }

    /**
     * 根据id删除对象
     * @param id
     */
    public void deleteProductTypeById(int id){
        productTypeMapper.deleteProductTypeById(id);
    }
}
