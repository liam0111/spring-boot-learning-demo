package com.liam.springboot.jdbc.repository;

import com.liam.springboot.jdbc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/25 17:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User("liam", "123456", 30);
        userRepository.save(user);
    }

    @Test
    public void testDelete() {
        userRepository.delete(1L);
    }

    @Test
    public void testQueryOne() {
        User user = userRepository.findById(2L);
        System.out.println("user === " + user.toString());
    }

    @Test
    public void testQueryAll() {
        List<User> users=userRepository.findAll();
        users.forEach(user -> System.out.println("user === " + user.toString()));
    }
}
