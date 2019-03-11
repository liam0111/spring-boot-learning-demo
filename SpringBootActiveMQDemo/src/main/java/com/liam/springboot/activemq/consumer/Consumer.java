package com.liam.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/10 22:02
 */
@Component
public class Consumer {
    @JmsListener(destination = "liam.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer queue msg: " + text);
    }

    @JmsListener(destination = "liam.topic")
    public void receiveTopic(String text) {
        System.out.println("Consumer topic msg: " + text);
    }
}
