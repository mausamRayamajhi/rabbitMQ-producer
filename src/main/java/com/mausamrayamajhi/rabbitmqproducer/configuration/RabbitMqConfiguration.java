package com.mausamrayamajhi.rabbitmqproducer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
    public static final String ROUTING_KEY = "my.queue.key";

    @Bean
    Queue queue() {
        return new Queue(ROUTING_KEY, true);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("my_queue_exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }
}