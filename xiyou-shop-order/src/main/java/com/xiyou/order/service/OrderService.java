package com.xiyou.order.service;

import com.xiyou.order.dao.OrderDao;
import com.xiyou.common.model.Order;
import com.xiyou.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 添加订单的相关信息
     * @param order
     */
    public void insertOrder(Order order){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String format = dateFormat.format(date);
        // 生成交易流水号
        String tradenumber = UUID.randomUUID().toString().replace("-", "") + format;
        // 添加交易流水号
        order.setTradenumber(tradenumber);
        order.setCreatetime(date);
        // 添加订单状态 0 正常，1 取消
        order.setOrderstatus(1);
        // 添加支付状态 1 表示未支付
        order.setPaystatus(1);
        orderDao.insertOrder(order);

    }

    /**
     * 查看相关的订单信息
     * @param orderVo
     * @return
     */
    public List<Order> listOrder(OrderVo orderVo){
        return orderDao.listOrder(orderVo);
    }


    /**
     * 更改订单的用户信息
     * @param
     */
    public void updateOrderWithUser(int id, String consigneeadress, String consigneename, String consigneephone){
        Order order = new Order();
        order.setId(id);
        order.setConsigneeadress(consigneeadress);
        order.setConsigneename(consigneename);
        order.setConsigneephone(consigneephone);
        orderDao.updateOrderWithUser(order);
    }

    /**
     * 根据id查找订单信息
     * @param id
     * @return
     */
    public Order findOrderById(int id){
        return orderDao.findOrderById(id);
    }

    /**
     * 根据id删除订单信息
     * @param id
     */
    public void deleteOrderById(int id){
        orderDao.deleteOrderById(id);
    }

    /**
     * 根据id更新订单信息
     * @param order
     */
    public void updateOrderById(Order order){
        orderDao.updateOrderById(order);
    }

}
