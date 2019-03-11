package com.liam.springboot.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Liam
 * @Date: 2018/11/29 21:30
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello world, " + name;
    }
}
