package com.xiyou.queueserver.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MsgSender implements RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Returned message callback.
     * @param message the returned message.
     * @param replyCode the reply code.
     * @param replyText the reply text.
     * @param exchange the exchange.
     * @param routingKey the routing key.
     */
    @Override
    public void returnedMessage(Message message,
                                int replyCode,
                                String replyText,
                                String exchange,
                                String routingKey) {
        System.out.println("message: " + message + "replyCode: " + replyCode + "replyText" + replyText +
                "exchange" + exchange + "routingKey" + routingKey);

    }


    /**
     * 发送消息
     */
    public void send(){
        String msg = "你好现在是: " + new Date() + "~";
        // 设置回调函数
        rabbitTemplate.setReturnCallback(this);
        // 该函数是回调函数，调用成功或者失败都会调用该函数
        /**
         * Confirmation callback.
         * @param correlationData correlation data for the callback.
         * @param ack true for ack, false for nack
         * @param cause An optional cause, for nack, when available, otherwise null.
         */
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause)->{
            if(!ack){
                // 消息发送失败
                System.out.println("消息发送失败的回调");
                System.out.println("correlationData: " + correlationData.toString());
                System.out.println("cause: " + cause);
            }else {
                // 消息发送成功
                System.out.println("消息发送成功的回调");
            }
        });

        rabbitTemplate.convertAndSend("ABExchange", "", msg);
    }
}
