package com.xiyou.order.controller;

import com.xiyou.common.model.Order;
import com.xiyou.common.model.OrderDetail;
import com.xiyou.common.vo.OrderAll;
import com.xiyou.order.service.OrderDetailService;
import com.xiyou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderOutController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    /**
     * 增加订单信息，包括详情信息
     * 注意一点，feign可以有多个@RequestParam 但是绝对不能有多个@RequestBody 最多只能有一个
     */
    @PostMapping("/insertOutOrder")
    public Integer insertOutOrder(@RequestBody OrderAll orderAll){
        Order order = orderAll.getOrder();
        OrderDetail orderDetail = orderAll.getOrderDetail();
        orderService.insertOrder(order);
        orderDetail.setCreatetime(order.getCreatetime());
        // 因为调用了insert的<selectKey>的方法，所以id进行了回写
        orderDetail.setOrderid(order.getId());
        orderDetailService.insertOrderDetail(orderDetail);
        return order.getId();
    }

}
