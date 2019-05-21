package com.xiyou.common.model;

import lombok.Data;

/**
 * 商品详情表
 */
@Data
public class ProductDetail {
    // id
    private int id;
    // 商品id
    private int proudctid;
    // 商品产地
    private String productplace;
    // 商品标题
    private String productitle;
    // 商品品牌
    private String productbrand;
    // 商品重量
    private String productweight;
    // 商品规格说明和包装
    private String productspecification;
    // 商品详情图片地址
    private String productdetaipicurl;
}
