package com.xiyou.mapper;

import com.xiyou.common.model.ProductType;
import com.xiyou.vo.ProductTypeVo;

import java.util.List;

public interface ProductTypeMapper {

    /**
     * 新增产品类型, 因为是<selectKey>标签所以id默认回写到形参中
     * @param productType
     */
    public void insertProductType(ProductType productType);

    /**
     * 根据id查找产品
     * @param id
     * @return
     */
    public ProductType findProductTypeById(int id);

    /**
     * 更新产品类型
     * @param productType
     */
    public void updateProductTypeById(ProductType productType);

    /**
     * 根据ProdyctTypeVo查询ProductType的信息
     * @param productTypeVo
     * @return
     */
    public List<ProductType> queryListByVo(ProductTypeVo productTypeVo);

    /**
     * 根据id删除对象
     * @param id
     */
    public void deleteProductTypeById(int id);

    /**
     * 查询所有的产品类型
     * @return
     */
    public List<ProductType> listAllProductType();
}
