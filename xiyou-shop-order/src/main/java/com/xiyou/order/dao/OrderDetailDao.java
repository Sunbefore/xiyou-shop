package com.xiyou.order.dao;

import com.xiyou.common.model.OrderDetail;
import com.xiyou.order.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailDao {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 增加订单详情的相关信息
     * @param orderDetail
     */
    public void insertOrderDetail(OrderDetail orderDetail){
        orderDetailMapper.insertOrderDetail(orderDetail);
    }
}
