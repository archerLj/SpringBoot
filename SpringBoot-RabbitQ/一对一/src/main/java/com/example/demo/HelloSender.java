package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by archerlj on 2017/6/20.
 */

/**
 *
 * 发送者
 *
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String content = "hello" + new Date();
        System.out.println(content);
        this.amqpTemplate.convertAndSend("hello", content);
    }
}
