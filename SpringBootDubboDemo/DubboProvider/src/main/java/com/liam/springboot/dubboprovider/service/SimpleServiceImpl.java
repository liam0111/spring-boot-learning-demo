package com.liam.springboot.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.liam.springboot.dubboapi.User;
import com.liam.springboot.dubboapi.SimpleService;

/**
 * @Author: Liam
 * @Date: 2019/3/13 18:41
 */
@Service(group = "dubbo", version = "1.0.0")
public class SimpleServiceImpl implements SimpleService {
    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }

    @Override
    public String sayHello2(String name) {
        return "hello: " + name;
    }

    @Override
    public String testPojo(User user) {
        return user.toString();
    }
}
