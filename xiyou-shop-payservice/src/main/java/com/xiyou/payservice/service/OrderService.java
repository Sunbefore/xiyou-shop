package com.xiyou.payservice.service;

import com.xiyou.common.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("xiyou-shop-order")
public interface OrderService {

    @RequestMapping(value = "/findOrderById", method = RequestMethod.POST)
    public Order findOrderById(@RequestParam("id") Integer id);

    /**
     * 根据order的id，支付状态，支付类型更新order
     * @param id
     * @param payType
     * @param payStatus
     */
    @RequestMapping(value = "/updateOrderById", method = RequestMethod.POST)
    public void updateOrderById(@RequestParam("id") int id,
                                @RequestParam("payType") int payType,
                                @RequestParam("payStatus") int payStatus);
}
