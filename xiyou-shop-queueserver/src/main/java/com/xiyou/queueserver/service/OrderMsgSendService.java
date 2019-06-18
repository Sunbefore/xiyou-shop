package com.xiyou.queueserver.service;

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

    /**
     * 发送字符串
     * @param msg
     */
    public void send(String msg){
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (!ack){
                System.out.println("消息发送失败");
            }else {
                System.out.println("消息发送成功");
            }
        }));

        rabbitTemplate.convertAndSend(RabbitConfig.SPRING_BOOT_EXCHANGE,
                RabbitConfig.SPRING_BOOT_BIND_KEY, msg);
    }


    /**
     * 发送OrderAll对象，进行传递
     * @param orderAll
     */
    public void sendObj(OrderAll orderAll){

        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (!ack){
                System.out.println("消息发送失败");
            }else {
                System.out.println("消息发送成功");
            }
        }));

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
