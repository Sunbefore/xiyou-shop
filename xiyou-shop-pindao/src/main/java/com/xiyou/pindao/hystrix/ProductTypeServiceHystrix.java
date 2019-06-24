package com.xiyou.pindao.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiyou.common.model.ProductType;
import com.xiyou.pindao.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * producttype的服务降级
 */
@Service
public class ProductTypeServiceHystrix {

    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 带有服务降级操作的查询所有服务类别
     * @return
     */
    @HystrixCommand(fallbackMethod = "listAllProductTypeFailBack")
    public List<ProductType> listAllProductType(){
        // int i = 1/0;
        return productTypeService.listAllProductType();
    }

    /**
     * 降级处理
     * @return
     */
    public List<ProductType> listAllProductTypeFailBack(Throwable throwable){
        System.out.println("listAllProductType调用失败");
        System.out.println(throwable.getStackTrace());

        // 固定写死一个productType, 将其返回
        // 通常情况下会查询所有的服务类型，这里简单去写了
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setParentid(-1);
        productType.setProducttypedescription("这是服务降级");
        productType.setProducttypename("服务降级");
        productType.setTypegrade("1");
        ArrayList<ProductType> productTypes = new ArrayList<>();
        productTypes.add(productType);
        return productTypes;
    }
}
