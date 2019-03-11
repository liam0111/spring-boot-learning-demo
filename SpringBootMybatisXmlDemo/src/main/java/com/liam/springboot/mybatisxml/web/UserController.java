package com.liam.springboot.mybatisxml.web;

import com.liam.springboot.mybatisxml.mapper.UserMapper;
import com.liam.springboot.mybatisxml.model.User;
import com.liam.springboot.mybatisxml.param.UserParam;
import com.liam.springboot.mybatisxml.result.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/27 17:50
 */
@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getList")
    public Page<User> getList(UserParam userParam) {
        List<User> users = userMapper.getList(userParam);
        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);
        return page;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}
