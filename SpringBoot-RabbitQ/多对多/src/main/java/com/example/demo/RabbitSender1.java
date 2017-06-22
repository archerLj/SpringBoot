package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/20.
 */

@Component
public class RabbitSender1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        System.out.println("Sender 1: " + i);
        this.amqpTemplate.convertAndSend("hello", new Integer(i));
    }
}
