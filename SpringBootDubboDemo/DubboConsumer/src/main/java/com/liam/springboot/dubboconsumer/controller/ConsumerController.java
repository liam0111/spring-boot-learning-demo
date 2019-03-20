package com.liam.springboot.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liam.springboot.dubboapi.SimpleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Liam
 * @Date: 2019/3/13 18:51
 */
@RestController
public class ConsumerController {
    @Reference(group = "dubbo", version = "1.0.0")
    private SimpleService simpleService;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return simpleService.sayHello(name);
    }
}
