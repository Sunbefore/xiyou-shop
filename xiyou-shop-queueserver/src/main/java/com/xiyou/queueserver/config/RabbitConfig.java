package com.xiyou.queueserver.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // 队列名称
    public final static String SPRING_BOOT_QUEUE = "order-queue";
    // 交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "order-exchange";
    // 绑定的值
    public static final String SPRING_BOOT_BIND_KEY = "order-bind-key-msg";

    @Bean
    public Queue queueA(){
        return new Queue("hello");
    }

    @Bean
    public Queue queueB(){
        return new Queue("helloObj");
    }

    @Bean
    public Queue queueC(){
        return new Queue(SPRING_BOOT_QUEUE);
    }

    /**
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("ABExchange");
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(SPRING_BOOT_EXCHANGE);
    }


    /**
     * 绑定相关的信息
     */
    @Bean
    public Binding bindingExchangeA(Queue queueA, FanoutExchange fanoutExchange){
        // 将队列A用指定的exchange进行绑定

        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue queueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(Queue queueC, TopicExchange topicExchange){
        return BindingBuilder.bind(queueC).to(topicExchange).with(SPRING_BOOT_BIND_KEY);
    }

    /**
     * 消息的格式化，将对象转换为json
     */
    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
