package com.xiyou.queueserver.service;

import com.alibaba.fastjson.JSONObject;
import com.xiyou.common.model.MessageLog;
import com.xiyou.common.vo.OrderAll;
import com.xiyou.queueserver.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMsgSendService implements RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageLogService messageLogService;

    /**
     * 发送字符串
     * @param msg
     */
    public void send(String msg){
        // 赋值相关的messageLog信息，做分布式事务
        MessageLog messageLog = new MessageLog();
        messageLog.setYwtype("order");
        // 初始化信息状态 1 表示的是未发送（这是初始化的状态）
        messageLog.setYwmessagestatus(1);
        messageLog.setYwmessage(msg);

        rabbitTemplate.setReturnCallback(this);
        /**
         * 此处的消息接收表示的是发送者给block发送的消息成功或者失败的反馈
         * 并不是消费者消费成功与否的反馈
         */
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (!ack){
                System.out.println("消息发送失败");
                // 发送失败
                messageLog.setYwmessagestatus(3);
            }else {
                System.out.println("消息发送成功");
                // 发送成功
                messageLog.setYwmessagestatus(2);
            }
        }));

        // 保存发送的信息状态
        messageLogService.insertMessageLog(messageLog);
        // 发送信息
        rabbitTemplate.convertAndSend(RabbitConfig.SPRING_BOOT_EXCHANGE,
                RabbitConfig.SPRING_BOOT_BIND_KEY, msg);
    }


    /**
     * 发送OrderAll对象，进行传递
     * @param orderAll
     */
    public void sendObj(OrderAll orderAll){

        // 将消息变为json
        String orderAllJsonString = JSONObject.toJSONString(orderAll);
        // 赋值相关的messageLog信息，做分布式事务
        MessageLog messageLog = new MessageLog();
        messageLog.setYwtype("order");
        // 初始化信息状态 1 表示的是未发送（这是初始化的状态）
        messageLog.setYwmessagestatus(1);
        messageLog.setYwmessage(orderAllJsonString);

        rabbitTemplate.setReturnCallback(this);
        /**
         * 此处的消息接收表示的是发送者给block发送的消息成功或者失败的反馈
         * 并不是消费者消费成功与否的反馈
         */
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (!ack){
                System.out.println("消息发送失败");
                // 发送失败
                messageLog.setYwmessagestatus(3);
            }else {
                System.out.println("消息发送成功");
                // 发送成功
                messageLog.setYwmessagestatus(2);
            }
        }));
        // 保存发送的信息状态
        messageLogService.insertMessageLog(messageLog);
        rabbitTemplate.convertAndSend(RabbitConfig.SPRING_BOOT_EXCHANGE,
                RabbitConfig.SPRING_BOOT_BIND_KEY, orderAll);
    }


    @Override
    public void returnedMessage(Message message,
                                int replyCode,
                                String replyText,
                                String exchange,
                                String routingKey) {

    }
}
