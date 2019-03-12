package com.liam.springboot.rabbitmq;

import com.liam.springboot.rabbitmq.model.User;
import com.liam.springboot.rabbitmq.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/3/11 22:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {
    @Autowired
    private ObjectSender sender;

    @Test
    public void sendObject() throws InterruptedException {
        User user = new User();
        user.setName("liam");
        user.setPassword("123456");
        sender.send(user);
        Thread.sleep(1000L);
    }
}
