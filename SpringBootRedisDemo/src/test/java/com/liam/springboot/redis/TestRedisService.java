package com.liam.springboot.redis;

import com.liam.springboot.redis.model.User;
import com.liam.springboot.redis.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/3/7 19:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisService {
    @Autowired
    private RedisService redisService;

    @Test
    public void testString() {
        redisService.set("liam", "liamshi");
        Assert.assertEquals("liamshi", redisService.get("liam"));
    }

    @Test
    public void testObj() {
        User user = new User("aa", "aa123456", "aa@qq.com", "aa", "2019");
        redisService.set("user", user);
        User userR = (User) redisService.get("user");
        System.out.println("userR== " + userR.toString());
    }
}
