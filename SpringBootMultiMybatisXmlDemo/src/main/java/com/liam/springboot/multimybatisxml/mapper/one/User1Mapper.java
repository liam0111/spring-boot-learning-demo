package com.liam.springboot.multimybatisxml.mapper.one;

import com.liam.springboot.multimybatisxml.model.User;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/27 22:20
 */
public interface User1Mapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
