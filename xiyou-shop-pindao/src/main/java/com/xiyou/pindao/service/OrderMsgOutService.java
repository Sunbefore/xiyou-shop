package com.xiyou.pindao.service;

import com.xiyou.common.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "xiyou-shop-queueserver")
public interface OrderMsgOutService {

    /**
     * 调用消息队列接口 发送消息
     * @param msg
     * @return
     */
    @RequestMapping(value = "/sendOrderMsg/{msg}", method = RequestMethod.GET)
    public String sendOrderMsg(@PathVariable("msg") String msg);


    /**
     * 发送订单和订单详情对象
     * @param orderAll
     * @return
     */
    @RequestMapping(value = "/sendOrderObj", method = RequestMethod.POST)
    public String sendOrderObj(@RequestBody OrderAll orderAll);
}
