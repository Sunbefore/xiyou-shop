package com.xiyou.order.service;

import com.xiyou.common.model.OrderDetail;
import com.xiyou.order.dao.OrderDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * 增加订单详情的相关信息
     * @param orderDetail
     */
    public void insertOrderDetail(OrderDetail orderDetail){
        orderDetailDao.insertOrderDetail(orderDetail);
    }
}
