package com.liam.springboot.mybatisxml.mapper;

import com.liam.springboot.mybatisxml.model.User;
import com.liam.springboot.mybatisxml.param.UserParam;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/26 18:18
 */
public interface UserMapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    int update(User user);

    int delete(Long id);

    List<User> getList(UserParam userParam);

    int getCount(UserParam userParam);
}
