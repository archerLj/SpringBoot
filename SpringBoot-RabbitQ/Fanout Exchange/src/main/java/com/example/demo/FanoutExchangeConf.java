package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by archerlj on 2017/6/21.
 */

@Configuration
public class FanoutExchangeConf {

    @Bean
    public Queue AMessage() {
        return new Queue("faout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("faout.B");
    }

    @Bean
    Queue CMessage() {
        return new Queue("faout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return  new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
 }
