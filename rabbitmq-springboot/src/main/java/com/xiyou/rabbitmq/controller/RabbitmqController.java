package com.xiyou.rabbitmq.controller;

import com.xiyou.rabbitmq.consumer.ReceiveMsg;
import com.xiyou.rabbitmq.po.MsgContent1;
import com.xiyou.rabbitmq.po.MsgContent2;
import com.xiyou.rabbitmq.send.SendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RabbitmqController {

    @Autowired
    private SendMsg sendMsg;

    @ResponseBody
    @GetMapping("/sendMsg")
    public String sendMsg(){
        MsgContent1 msgContent1 = new MsgContent1();
        msgContent1.setAge("1");
        msgContent1.setName("msg1");
        MsgContent2 msgContent2 = new MsgContent2();
        msgContent2.setId("2");
        msgContent2.setContent("msg2");
        sendMsg.send("string:this msg I will send....");
        sendMsg.sendMsgObject1(msgContent1);
        sendMsg.sendMsgObject2(msgContent2);
        return "ok";
    }

}
