package com.liam.springboot.multijdbc.repository;

import com.liam.springboot.multijdbc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/2/26 15:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    public void testSave() {
        User user = new User("liamliam", "123456", 30);
        userRepository.save(user, primaryJdbcTemplate);
        userRepository.save(user, secondaryJdbcTemplate);
        userRepository.save(user, null);
    }
}
