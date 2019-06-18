package com.xiyou.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.xiyou.rabbitmq.config.RabbitMqConfig;
import com.xiyou.rabbitmq.po.MsgContent1;
import com.xiyou.rabbitmq.po.MsgContent2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener可以写在类上面
 * 写在类上面之后，在方法上标注@RabbitHandler可以自动根据参数的不同传递到不同的方法中
 */
@Component
@RabbitListener(queues = RabbitMqConfig.SPRING_BOOT_QUEUE)
public class ReceiveMsgObject {

    @RabbitHandler
    public void receiveMsg1(MsgContent1 msgContent1, Message message, Channel channel){
        System.out.println(msgContent1);
    }

    @RabbitHandler
    public void receiveMsg2(MsgContent2 msgContent2, Message message, Channel channel){
        System.out.println(msgContent2);
    }

    @RabbitHandler
    public void receiveMsg3(String msg, Message message, Channel channel){
        System.out.println(msg);
    }

}
