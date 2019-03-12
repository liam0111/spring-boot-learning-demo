package com.liam.springboot.rabbitmq.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/11 21:57
 */
@Component
@RabbitListener(queues = "many")
public class ManyReceiver2 {
    @RabbitHandler
    public void process(String liam) {
        System.out.println("Receiver2: " + liam);
    }
}
