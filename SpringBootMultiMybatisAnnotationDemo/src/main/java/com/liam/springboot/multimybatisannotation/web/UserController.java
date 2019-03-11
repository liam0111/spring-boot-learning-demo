package com.liam.springboot.multimybatisannotation.web;

import com.liam.springboot.multimybatisannotation.mapper.one.User1Mapper;
import com.liam.springboot.multimybatisannotation.mapper.two.User2Mapper;
import com.liam.springboot.multimybatisannotation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/28 22:51
 */
@RestController
public class UserController {
    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = user1Mapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = user2Mapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        user2Mapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        user2Mapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
}
