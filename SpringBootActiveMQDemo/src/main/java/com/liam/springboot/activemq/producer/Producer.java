package com.liam.springboot.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: Liam
 * @Date: 2019/3/10 21:56
 */
@Component
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    public void sendQueue(String msg) {
        System.out.println("send queue msg: " + msg);
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    public void sendTopic(String msg) {
        System.out.println("send topic msg: " + msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}
