package com.xiyou.pindao.model;

import lombok.Data;

import java.util.Date;

/**
 * 商品的相关信息
 */

@Data
public class Product {
    // 主键
    private int id;
    // 商品类别id
    private int producttypeid;
    // 商品标题
    private String producttitle;
    // 商品价格
    private int productprice;
    // 商家id
    private int mechartid;
    // 创建时间
    private Date createtime;
    // 审核时间
    private Date audittime;
    // 审核状态 0 未审核 1 审核通过 2 审核不通过
    private int auditstate;
    // 库存
    private int stocknum;
    // 销售数量
    private int sellnum;
    // 商品图片地址
    private String productpicurl;
    // 商品上下架 0 代表上架 1 代表下架
    private int productstatus;
}
