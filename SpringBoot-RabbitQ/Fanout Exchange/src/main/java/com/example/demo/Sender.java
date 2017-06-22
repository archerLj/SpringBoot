package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/21.
 */

@Component
public class Sender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send() {

        String content = "message from sender";
        System.out.println("Sender : " + content);
        this.amqpTemplate.convertAndSend("fanoutExchange","",content);
    }
}
