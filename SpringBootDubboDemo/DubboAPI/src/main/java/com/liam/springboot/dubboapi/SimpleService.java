package com.liam.springboot.dubboapi;

/**
 * @Author: Liam
 * @Date: 2019/3/13 18:33
 */
public interface SimpleService {
    String sayHello(String name);

    String sayHello2(String name);

    String testPojo(User user);
}
