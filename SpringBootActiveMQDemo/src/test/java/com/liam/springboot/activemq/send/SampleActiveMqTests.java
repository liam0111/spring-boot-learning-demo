package com.liam.springboot.activemq.send;

import com.liam.springboot.activemq.producer.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/3/10 22:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveMqTests {
    @Autowired
    private Producer producer;

    @Test
    public void sendSimpleQueueMessage() throws InterruptedException {
        this.producer.sendQueue("Test queue message");
        Thread.sleep(1000L);
    }

    @Test
    public void send100QueueMessage() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.producer.sendQueue("Test queue message" + i);
        }
        Thread.sleep(1000L);
    }

    @Test
    public void sendSimpleTopicMessage() throws InterruptedException {
        this.producer.sendTopic("Test topic message");
        Thread.sleep(1000L);
    }

    @Test
    public void send100TopicMessage() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.producer.sendTopic("Test topic message" + i);
        }
        Thread.sleep(1000L);
    }
}
