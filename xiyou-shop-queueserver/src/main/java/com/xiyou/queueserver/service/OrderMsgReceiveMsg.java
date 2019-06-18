package com.xiyou.queueserver.service;

import com.rabbitmq.client.Channel;
import com.xiyou.common.vo.OrderAll;
import com.xiyou.queueserver.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RabbitListener(queues = RabbitConfig.SPRING_BOOT_QUEUE)
public class OrderMsgReceiveMsg {

    @Autowired
    private OrderService orderService;

    /**
     * 后两个参数自动注入
     * @param msg
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitHandler
    public void process(String msg, Message message, Channel channel) throws IOException {
        System.out.println("接受到的消息是：" + msg);
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("receiver success");
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("receiver fail");
        }
    }

    /**
     * 接受发送过来的对象
     * @param orderAll
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitHandler
    public void process(OrderAll orderAll, Message message, Channel channel) throws IOException {
        System.out.println("接受到的消息是：" + orderAll);
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            // 新增订单的业务逻辑
            orderService.insertOutOrder(orderAll);
            System.out.println("receiver success");
        } catch (Exception e) {
            e.printStackTrace();
            // 如果报错 最后一个参数为true表示重新回到消息队列中 继续等待消费
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
            System.out.println("receiver fail");
        }
    }

}
