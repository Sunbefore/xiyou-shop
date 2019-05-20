package com.xiyou.order.dao;

import com.xiyou.order.mapper.OrderMapper;
import com.xiyou.order.model.Order;
import com.xiyou.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 添加订单的相关信息
     * @param order
     */
    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
    }

    /**
     * 查看相关的订单信息
     * @param orderVo
     * @return
     */
    public List<Order> listOrder(OrderVo orderVo){
        return orderMapper.listOrder(orderVo);
    }

    /**
     * 更改订单的用户信息
     * @param order
     */
    public void updateOrderWithUser(Order order){
        orderMapper.updateOrderWithUser(order);
    }

    /**
     * 根据id查找订单信息
     * @param id
     * @return
     */
    public Order findOrderById(int id){
        return orderMapper.findOrderById(id);
    }

    /**
     * 根据id删除订单信息
     * @param id
     */
    public void deleteOrderById(int id){
        orderMapper.deleteOrderById(id);
    }

    /**
     * 根据id更新订单信息
     * @param order
     */
    public void updateOrderById(Order order){
        orderMapper.updateOrderById(order);
    }
}
