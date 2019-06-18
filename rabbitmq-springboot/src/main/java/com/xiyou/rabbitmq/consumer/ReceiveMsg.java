package com.xiyou.rabbitmq.consumer;

import com.xiyou.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMsg {

    /**
     * 下面的方法是直接在注解中将队列，exchange和binding创建完毕
     * @RabbitListener(
        containerFactory = "rabbitListenerContainerFactory",
        bindings = @QueueBinding(
        value = @Queue(value = RabbitMqConfig.SPRING_BOOT_QUEUE,
        durable = "true",
        autoDelete = "true"),
        exchange = @Exchange(value = RabbitMqConfig.SPRING_BOOT_EXCHANGE,
        type = ExchangeTypes.TOPIC),
        key = RabbitMqConfig.SPRING_BOOT_BIND_KEY
        )
        )

     * 第二种方法就是直接在config文件中声明（@Bean）的方式声明队列 交换机 绑定
     * @param msg
     */
    @RabbitListener(queues = RabbitMqConfig.SPRING_BOOT_QUEUE)
    public void receive(String msg){
        System.out.println("接收到的信息是：" + msg);
    }
}
