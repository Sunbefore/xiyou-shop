package com.xiyou.order.mapper;

import com.xiyou.common.model.Order;
import com.xiyou.order.vo.OrderVo;

import java.util.List;

/**
 * Created by Administrator on 2018/6/23 0023.
 */
public interface OrderMapper {
    /**
     * 添加订单的相关信息
     * @param order
     */
    public void insertOrder(Order order);


    /**
     * 查看相关的订单信息
     * @param orderVo
     * @return
     */
    public List<Order> listOrder(OrderVo orderVo);

    /**
     * 更改订单的用户信息
     * @param order
     */
    public void updateOrderWithUser(Order order);

    /**
     * 根据id查找订单信息
     * @param id
     * @return
     */
    public Order findOrderById(int id);

    /**
     * 根据id删除订单信息
     * @param id
     */
    public void deleteOrderById(int id);

    /**
     * 根据id更新订单信息
     * @param order
     */
    public void updateOrderById(Order order);

    /**
     * 根据userId查询订单信息
     * @param userid
     * @return
     */
    public List<Order> listOrderByUserId(int userid);

    /**
     * 根据交易流水号查询订单
     * @param tradenumber
     * @return
     */
    public Order findOrderByTradeNumber(String tradenumber);

}
