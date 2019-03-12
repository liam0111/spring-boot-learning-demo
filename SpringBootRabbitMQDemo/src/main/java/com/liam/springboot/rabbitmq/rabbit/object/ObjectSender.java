package com.liam.springboot.rabbitmq.rabbit.object;

import com.liam.springboot.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/11 22:37
 */
@Component
public class ObjectSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.amqpTemplate.convertAndSend("object", user);
    }
}
