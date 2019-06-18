package com.xiyou.rabbitmq.send;

import com.xiyou.rabbitmq.config.RabbitMqConfig;
import com.xiyou.rabbitmq.po.MsgContent1;
import com.xiyou.rabbitmq.po.MsgContent2;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendMsg {
    // AmqpAdmin是一个接口
    // AdqpAmin是RabbitAdmin的抽象
    // RabbitTemplate是其实现
    @Autowired
    private AmqpAdmin amqpAdmin;

    // ampbTemplate的接口默认实现是RabbitTemplate
    // 所以amqpTemplate和amqpAdmin是可以互换的
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     */
    public void send(String msg){
        // 发送消息的时候要告诉其发送的exchange和bind（其实就是路由 因为路由需要和queue的绑定一致），这样才能确定发送到哪一个queue中
        amqpTemplate.convertAndSend(RabbitMqConfig.SPRING_BOOT_EXCHANGE,
                RabbitMqConfig.SPRING_BOOT_BIND_KEY, msg);
    }

    /**
     * 发送msg1
     */
    public void sendMsgObject1(MsgContent1 msgContent1){
        amqpTemplate.convertAndSend(RabbitMqConfig.SPRING_BOOT_EXCHANGE,
                RabbitMqConfig.SPRING_BOOT_BIND_KEY, msgContent1);
    }

    /**
     * 发送msg2
     */
    public void sendMsgObject2(MsgContent2 msgContent2){
        amqpTemplate.convertAndSend(RabbitMqConfig.SPRING_BOOT_EXCHANGE,
                RabbitMqConfig.SPRING_BOOT_BIND_KEY, msgContent2);
    }
}
