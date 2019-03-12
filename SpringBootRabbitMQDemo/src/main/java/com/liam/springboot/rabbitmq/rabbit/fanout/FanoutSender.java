package com.liam.springboot.rabbitmq.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/11 23:15
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hi, fanout msg";
        System.out.println("Sender: " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }
}
