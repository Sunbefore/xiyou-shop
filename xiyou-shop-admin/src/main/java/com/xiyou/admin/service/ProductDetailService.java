package com.xiyou.admin.service;


import com.xiyou.common.model.ProductDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/6/18 0018.
 */
@FeignClient(value = "xiyou-shop-product")
public interface ProductDetailService {

    /**
     * 新增产品详情
     * @param productDetail
     */
    @RequestMapping(value = "/insertProductDetail",method = RequestMethod.POST)
    public void insertProductDetail(@RequestBody ProductDetail productDetail);

}
