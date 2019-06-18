package com.xiyou.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 创建rabbitmq的生产者
 */
public class RabbitProducer {
    // 创建exchage的name
    private static final String EXCHANGE_NAME = "exchange_demo";
    // 创建路由routing
    private static final String ROUTING_KEY = "routingkey_demo";
    // 创建队列的名字
    private static final String QUEUE_NAME = "queue_demo";
    // rabbitmq的ip
    private static final String IP_ADDRESS = "192.168.0.108";
    // RabbitMQ服务端默认端口号为5672,不是15672,15672控制台的端口号
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建rabbitmq的工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 赋值ip
        connectionFactory.setHost(IP_ADDRESS);
        // 赋值port
        connectionFactory.setPort(PORT);
        // 设置其用户名和密码
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        // 建立连接
        Connection connection = connectionFactory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 创建一个type是点对点的，持久化的(durable)，非自动化删除的队列
        /**
         * Declare an exchange.
         * @see com.rabbitmq.client.AMQP.Exchange.Declare
         * @see com.rabbitmq.client.AMQP.Exchange.DeclareOk
         * @param exchange the name of the exchange
         * @param type the exchange type
         * @param durable true if we are declaring a durable exchange (the exchange will survive a server restart)
         * @param autoDelete true if the server should delete the exchange when it is no longer in use
         * @param arguments other properties (construction arguments) for the exchange
         * @return a declaration-confirm method to indicate the exchange was successfully declared
         * @throws java.io.IOException if an error is encountered
         */
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 声明一个queue
        // 该queue是一个可以持久化的，非专用的，非自动删除的，且没有额外的参数的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 绑定交换器和队列 通过路由绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        // 发送一条信息
        String message = "Hello World RabbitMQ";
        // 发送消息的时候需要指明EXCHANGE_NAME和ROUTING_KEY
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        // 关闭资源
        channel.close();
        connection.close();
    }
}
