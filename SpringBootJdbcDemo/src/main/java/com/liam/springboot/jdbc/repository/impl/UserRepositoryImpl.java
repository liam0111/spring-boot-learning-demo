package com.liam.springboot.jdbc.repository.impl;

import com.liam.springboot.jdbc.model.User;
import com.liam.springboot.jdbc.repository.UserRepository;
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
 * @Date: 2019/2/24 22:36
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        return jdbcTemplate
                .update("INSERT INTO users(name, password, age) VALUES (?, ?, ?)", user.getName(), user.getPassword(),
                        user.getAge());
    }

    @Override
    public int update(User user) {
        return jdbcTemplate
                .update("UPDATE users SET name = ?, password = ?, age = ? WHERE id = ?", user.getName(), user.getPassword(),
                        user.getAge(),
                        user.getId());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id},
                                           new BeanPropertyRowMapper<User>(User.class));
    }

    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }
    }
}
