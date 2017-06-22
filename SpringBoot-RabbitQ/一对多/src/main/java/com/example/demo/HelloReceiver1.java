package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/20.
 */

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(Integer i) {
        System.out.println("Reciver 1: " + i.intValue());
    }
}
