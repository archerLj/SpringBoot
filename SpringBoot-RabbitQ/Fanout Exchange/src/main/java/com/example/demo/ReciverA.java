package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/21.
 */

@Component
@RabbitListener(queues = "faout.A")
public class ReciverA {

    @RabbitHandler
    public void process(String txt) {
        System.out.println("reciver A: " + txt);
    }
}
