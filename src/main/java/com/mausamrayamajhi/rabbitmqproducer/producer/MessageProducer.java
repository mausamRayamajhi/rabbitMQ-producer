package com.mausamrayamajhi.rabbitmqproducer.producer;

import com.mausamrayamajhi.rabbitmqproducer.configuration.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage( String message){
        System.out.println(new Date());
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.ROUTING_KEY,message);
        System.out.println("Is listner returned ::: "+rabbitTemplate.isReturnListener());

    }
}
