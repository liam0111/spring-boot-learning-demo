package com.liam.springboot.rabbitmq.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/11 21:55
 */
@Component
public class ManySender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String context = "SpringBoot many queue" + " ****** " + i;
        System.out.println("Sender1: " + context);
        this.amqpTemplate.convertAndSend("many", context);
    }
}
