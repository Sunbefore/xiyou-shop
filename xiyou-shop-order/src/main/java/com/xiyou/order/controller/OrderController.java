package com.xiyou.order.controller;

import com.xiyou.order.model.Order;
import com.xiyou.order.service.OrderService;
import com.xiyou.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 跳转到添加订单的页面
     * @param
     */
    @GetMapping("/toInsertOrder")
    public String toInsertOrder(){
        return "insertOrder";
    }

    /**
     * 添加订单的相关信息
     * @param order
     */
    @PostMapping("/insertOrder")
    public void insertOrder(Order order){
        orderService.insertOrder(order);
    }


    /**
     * 跳转到查看相关的订单信息的页面
     * @param orderVo
     * @return
     */
    @GetMapping("/listOrder")
    public String listOrder(OrderVo orderVo, Model model){
        List<Order> list = orderService.listOrder(orderVo);
        model.addAttribute("orderlist", list);
        return "listorder";
    }

    /**
     * 跳转到订单用户信息修改页面
     * @param model
     * @return
     */
    @GetMapping("/toUpdateOrderInfoWithMechart/{id}")
    public String toUpdateOrderInfoWithMechart(@PathVariable Integer id, Model model){
        Order order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "updateOrderWithMechart";
    }

    /**
     * 更改订单的用户信息
     * @param
     */
    @PostMapping("/updateOrderInfoWithMechart")
    public void updateOrderInfoWithMechart(int id, String consigneeadress, String consigneename, String consigneephone){
        orderService.updateOrderWithUser(id, consigneeadress, consigneename, consigneephone);
    }

    /**
     * 根据id查找订单信息
     * @param id
     * @return
     */
    @GetMapping("/toViewOrder/{id}")
    public String findOrderById(@PathVariable Integer id, Model model){
        Order order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "viewOrder";
    }

    /**
     * 根据id删除订单信息
     * @param id
     */
    @GetMapping("/deleteOrderById/{id}")
    public void deleteOrderById(@PathVariable Integer id){
        orderService.deleteOrderById(id);
    }

    /**
     * 根据id更新订单信息
     * @param order
     */
    public void updateOrderById(Order order){
        orderService.updateOrderById(order);
    }
}
