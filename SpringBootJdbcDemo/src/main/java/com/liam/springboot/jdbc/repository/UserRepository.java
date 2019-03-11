package com.liam.springboot.jdbc.repository;

import com.liam.springboot.jdbc.model.User;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/24 22:34
 */
public interface UserRepository {
    int save(User user);

    int update(User user);

    int delete(long id);

    List<User> findAll();

    User findById(long id);
}
