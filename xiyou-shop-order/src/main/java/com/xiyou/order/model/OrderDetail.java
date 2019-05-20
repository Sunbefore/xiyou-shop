package com.xiyou.order.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/23 0023.
 */
@Data
public class OrderDetail {
   private int id;//主键
    private int orderid;//订单id
    private int productid;//商品id
    private int mechartid;//商家id
    private Date createtime;//创建时间
    private int  tradenum;//交易数量
}
