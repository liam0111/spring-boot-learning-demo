package com.liam.springboot.multijdbc.repository;

import com.liam.springboot.multijdbc.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/25 23:06
 */
public interface UserRepository {
    int save(User user, JdbcTemplate jdbcTemplate);

    int update(User user, JdbcTemplate jdbcTemplate);

    int delete(long id, JdbcTemplate jdbcTemplate);

    List<User> findAll(JdbcTemplate jdbcTemplate);

    User findById(long id, JdbcTemplate jdbcTemplate);
}
