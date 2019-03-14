package com.mausamrayamajhi.rabbitmqproducer.controller;

import com.mausamrayamajhi.rabbitmqproducer.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
    @Autowired
   private MessageProducer messageProducer;

    @GetMapping
    public String produce(@RequestParam String message){
        messageProducer.sendMessage(message);
        return "Message send to RabbitMQ and message = "+message;
    }



}
