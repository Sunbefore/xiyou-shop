package com.xiyou.order.mapper;


import com.xiyou.common.model.OrderDetail;

public interface OrderDetailMapper {
    /**
     * 增加订单详情的相关信息
     * @param order
     */
    public void insertOrderDetail(OrderDetail order);
}
