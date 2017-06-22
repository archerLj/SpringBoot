package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by archerlj on 2017/6/20.
 */

@Component
@RabbitListener(queues = "hello")
public class RabbitReciver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Reciver : " + user);
    }
}
