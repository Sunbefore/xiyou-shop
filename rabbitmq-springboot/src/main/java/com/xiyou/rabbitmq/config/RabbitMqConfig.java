package com.xiyou.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
    // 队列名称
    public final static String SPRING_BOOT_QUEUE = "spring-boot-queue-3";
    // 交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "spring-boot-exchange-3";
    // 绑定的值
    public static final String SPRING_BOOT_BIND_KEY = "spring-boot-bind-key-3";

    /**
     * 定义quue
     */
    @Bean
    public Queue queue(){
        return new Queue(SPRING_BOOT_QUEUE, false);
    }

    /**
     * 定义exchange
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(SPRING_BOOT_EXCHANGE);
    }

    /**
     * 定义binding
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        // 新建立一个绑定 该绑定以binding_key 绑定队列queue和exchange
        return BindingBuilder.bind(queue).to(exchange).with(SPRING_BOOT_BIND_KEY);
    }

    /**
     * 消息转换器 用来发送对象
     */
    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


}
