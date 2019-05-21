package com.xiyou.service;

import com.xiyou.common.model.ProductType;
import com.xiyou.dao.ProductTypeDao;
import com.xiyou.vo.ProductTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    /**
     * 新增产品类型, 因为是<selectKey>标签所以id默认回写到形参中
     * @param productType
     */
    public void insertProductType(ProductType productType){
        productTypeDao.insertProductType(productType);
    }

    /**
     * 根据id查找产品
     * @param id
     * @return
     */
    public ProductType findProductTypeById(int id){
        return productTypeDao.findProductTypeById(id);
    }

    /**
     * 更新产品类型
     * @param productType
     */
    public void updateProductTypeById(ProductType productType){
        productTypeDao.updateProductTypeById(productType);
    }

    /**
     * 根据ProdyctTypeVo查询ProductType的信息
     * @param productTypeVo
     * @return
     */
    public List<ProductType> queryListByVo(ProductTypeVo productTypeVo){
        return productTypeDao.queryListByVo(productTypeVo);
    }

    /**
     * 根据id删除对象
     * @param id
     */
    public void deleteProductTypeById(int id){
        productTypeDao.deleteProductTypeById(id);
    }

    /**
     * 查询所有的产品类型
     * @return
     */
    public List<ProductType> listAllProductType() {
        return productTypeDao.listAllProductType();
    }
}
