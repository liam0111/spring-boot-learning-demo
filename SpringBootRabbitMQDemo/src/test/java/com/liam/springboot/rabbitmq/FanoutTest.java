package com.liam.springboot.rabbitmq;

import com.liam.springboot.rabbitmq.rabbit.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/3/11 23:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {
    @Autowired
    private FanoutSender sender;

    @Test
    public void fanoutSender() throws InterruptedException {
        sender.send();
        Thread.sleep(1000L);
    }
}
