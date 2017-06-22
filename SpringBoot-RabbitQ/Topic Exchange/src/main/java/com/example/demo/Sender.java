package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/21.
 */

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1() {
        String content = "message 1";
        System.out.println("sender send message 1");
        this.amqpTemplate.convertAndSend("exchange", "topic.message", content);
    }

    public void send2() {
        String content = "message 2";
        System.out.println("sender send message 2");
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", content);
    }
}
