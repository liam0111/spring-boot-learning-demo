package com.liam.springboot.rabbitmq;

import com.liam.springboot.rabbitmq.rabbit.many.ManySender;
import com.liam.springboot.rabbitmq.rabbit.many.ManySender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/3/11 21:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
    @Autowired
    private ManySender sender;
    @Autowired
    private ManySender2 sender2;

    @Test
    public void oneToMany() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            sender.send(i);
        }
        Thread.sleep(1000L);
    }

    @Test
    public void manyToMany() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            sender.send(i);
            sender2.send(i);
        }
        Thread.sleep(10000L);
    }
}
