package com.liam.springboot.cache.web;

import com.liam.springboot.cache.model.User;
import com.liam.springboot.cache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/3/8 19:32
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    @Cacheable(value = "helloCache")
    public String hello(String name) {
        System.out.println("没有走缓存");
        return "hello " + name;
    }

    @RequestMapping("/condition")
    @Cacheable(value = "condition", condition = "#name.length() <= 4")
    public String condition(String name) {
        System.out.println("没有走缓存");
        return "hello " + name;
    }

    @RequestMapping("/getUsers")
    @Cacheable(value = "usersCache", key = "#nickname", condition = "#nickname.length() >= 6")
    public List<User> getUsers(String nickname) {
        List<User> users = userRepository.findByNickname(nickname);
        System.out.println("执行了数据库操作");
        return users;
    }

    @RequestMapping("/getPutUsers")
    @CachePut(value = "usersCache", key = "#nickname")
    public List<User> getPutUsers(String nickname) {
        List<User> users = userRepository.findByNickname(nickname);
        System.out.println("执行了数据库操作");
        return users;
    }

    @RequestMapping("/allEntries")
    @CacheEvict(value = "usersCache", allEntries = true)
    public List<User> allEntries(String nickname) {
        List<User> users = userRepository.findByNickname(nickname);
        System.out.println("执行了数据库操作");
        return users;
    }

    @RequestMapping("/beforeInvocation")
    @CacheEvict(value = "usersCache", allEntries = true, beforeInvocation = true)
    public void beforeInvocation() {
        throw new RuntimeException("test beforeInvocation");
    }
}
