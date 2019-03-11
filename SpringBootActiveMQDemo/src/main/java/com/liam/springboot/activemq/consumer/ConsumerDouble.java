package com.liam.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/11 15:29
 */
@Component
public class ConsumerDouble {
    @JmsListener(destination = "liam.queue", containerFactory = "queueListenerFactory")
    public void receiveQueue(String text) {
        System.out.println("Consumer queue msg: " + text);
    }

    @JmsListener(destination = "liam.topic", containerFactory = "topicListenerFactory")
    public void receiveTopic(String text) {
        System.out.println("Consumer topic msg: " + text);
    }
}
