package com.xiyou.queueserver.controller;

import com.xiyou.common.vo.OrderAll;
import com.xiyou.queueserver.service.OrderMsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderOutController {

    @Autowired
    private OrderMsgSendService orderMsgSendService;

    @GetMapping("/sendOrderMsg/{msg}")
    public String sendOrderMsg(@PathVariable String msg){
        orderMsgSendService.send(msg);
        return "ok";
    }

    @PostMapping("/sendOrderObj")
    public String sendOrderObj(@RequestBody OrderAll orderAll){
        orderMsgSendService.sendObj(orderAll);
        return "ok";
    }
}
