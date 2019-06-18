package com.xiyou.pindao.service;

import com.xiyou.common.model.Order;
import com.xiyou.common.model.OrderDetail;
import com.xiyou.common.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("xiyou-shop-order")
public interface OrderService {

    /**
     * 增加订单信息，包括详情信息
     */
    @RequestMapping(value = "/insertOutOrder", method = RequestMethod.POST)
    public Integer insertOutOrder(@RequestBody OrderAll orderAll);

    /**
     * 根据userId查询订单信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/listOrderByUserId/{userId}")
    public List<Order> listOrderByUserId(@PathVariable("userId") Integer userId);

    /**
     * 根据交易流水号查询订单
     * @param tradeNumber
     * @return
     */
    @RequestMapping(value = "/findOrderByTradeNumber/{tradeNumber}")
    public Order findOrderByTradeNumber(@PathVariable("tradeNumber") String tradeNumber);
}
