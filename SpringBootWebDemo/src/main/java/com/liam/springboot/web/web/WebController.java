package com.liam.springboot.web.web;

import com.liam.springboot.web.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 总控制器
 *
 * @Author: Liam
 * @Date: 2018/12/1 18:05
 */
@RestController
public class WebController {
    @RequestMapping(name = "/getUser", method = RequestMethod.POST)
    public User getUser() {
        User user = new User();
        user.setName("Liam");
        user.setAge(12);
        user.setPass("123456");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = new ArrayList();
        User user1 = new User();
        user1.setName("user1");
        user1.setAge(30);
        user1.setPass("123456");
        users.add(user1);
        User user2 = new User();
        user2.setName("user2");
        user2.setAge(12);
        user2.setPass("654321");
        users.add(user2);
        return users;
    }

    @RequestMapping("saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user: " + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }

    /* 传参的各种方式
    @RequestMapping("/get1")
    public String get1(User user) {
        return user.getName();
    }

    @RequestMapping(value = "get2/{name}", method = RequestMethod.GET)
    public String get2(User user) {
        return user.getName();
    }

    @RequestMapping(value = "get3/{name}", method = RequestMethod.GET)
    public String get3(@PathVariable String name) {
        return name;
    }
    */
}
