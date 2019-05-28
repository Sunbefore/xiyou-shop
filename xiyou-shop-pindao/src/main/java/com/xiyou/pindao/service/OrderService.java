package com.xiyou.pindao.service;

import com.xiyou.common.model.Order;
import com.xiyou.common.model.OrderDetail;
import com.xiyou.common.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("xiyou-shop-order")
public interface OrderService {

    /**
     * 增加订单信息，包括详情信息
     */
    @RequestMapping(value = "/insertOutOrder", method = RequestMethod.POST)
    public Integer insertOutOrder(@RequestBody OrderAll orderAll);

}
