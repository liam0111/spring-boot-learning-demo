package com.liam.springboot.multijdbc.repository.impl;

import com.liam.springboot.multijdbc.model.User;
import com.liam.springboot.multijdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/25 23:06
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public int save(User user, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.update("INSERT INTO users(name, password, age) VALUES (?, ?, ?)", user.getName(), user.getPassword(),
                                   user.getAge());
    }

    @Override
    public int update(User user, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate
                .update("UPDATE users SET name = ?, password = ?, age = ? WHERE id = ?", user.getName(), user.getPassword(),
                        user.getAge(), user.getId());
    }

    @Override
    public int delete(long id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.update("DELETE FROM users WHERE id = ? ", id);

    }

    @Override
    public User findById(long id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate
                .queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id},
                                new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> findAll(JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }

}