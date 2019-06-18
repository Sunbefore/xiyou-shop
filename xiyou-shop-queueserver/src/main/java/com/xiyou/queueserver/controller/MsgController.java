package com.xiyou.queueserver.controller;

import com.xiyou.queueserver.utils.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsgController {

    @Autowired
    private MsgSender msgSender;

    /**
     * 单生产者-单个消费者
     */
    @GetMapping("/test")
    @ResponseBody
    public String hello() throws Exception {
        msgSender.send();
        return "ok";
    }
}
