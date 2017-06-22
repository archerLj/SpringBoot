package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/20.
 */

@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender(User user) {
        System.out.println("Sender : " + user);
        this.amqpTemplate.convertAndSend("hello", user);
    }
}
