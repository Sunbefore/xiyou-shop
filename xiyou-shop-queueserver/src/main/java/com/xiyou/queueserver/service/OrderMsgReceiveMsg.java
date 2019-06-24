package com.xiyou.queueserver.service;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.xiyou.common.model.MessageLog;
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

    @Autowired
    private MessageLogService messageLogService;

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

        // 赋值相关的messageLog信息，做分布式事务
        MessageLog messageLog = new MessageLog();
        messageLog.setYwtype("order");
        // 初始化信息状态 4 表示的是消费者未接受（这是初始化的状态）
        messageLog.setYwmessagestatus(4);
        messageLog.setYwmessage(message.getBody().toString());

        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("receiver success");

            // 已经消费
            messageLog.setYwmessagestatus(5);
        } catch (Exception e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            System.out.println("receiver fail");

            // 消费失败
            messageLog.setYwmessagestatus(6);
        }

        messageLogService.updateMessageLog(messageLog);
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

        // 将接收到的信息变为json 进行存储
        String orderAllJsonString = JSONObject.toJSONString(orderAll);

        // 赋值相关的messageLog信息，做分布式事务
        MessageLog messageLog = new MessageLog();
        messageLog.setYwtype("order");
        // 初始化信息状态 4 表示的是消费者未接受（这是初始化的状态）
        messageLog.setYwmessagestatus(4);
        messageLog.setYwmessage(orderAllJsonString);

        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            // 新增订单的业务逻辑
            orderService.insertOutOrder(orderAll);
            System.out.println("receiver success");
            // 已经消费
            messageLog.setYwmessagestatus(5);
        } catch (Exception e) {
            e.printStackTrace();
            // 如果报错 最后一个参数为true表示重新回到消息队列中 继续等待消费
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
            System.out.println("receiver fail");
            // 消费失败
            messageLog.setYwmessagestatus(6);
        }
        // 更新message日志
        messageLogService.updateMessageLog(messageLog);
    }

}
