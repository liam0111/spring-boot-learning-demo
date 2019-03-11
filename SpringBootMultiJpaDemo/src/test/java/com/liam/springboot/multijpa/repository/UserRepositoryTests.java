package com.liam.springboot.multijpa.repository;

import com.liam.springboot.multijpa.model.User;
import com.liam.springboot.multijpa.repository.one.UserOneRepository;
import com.liam.springboot.multijpa.repository.two.UserTwoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * @Author: Liam
 * @Date: 2019/3/6 19:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Resource
    private UserOneRepository userOneRepository;
    @Resource
    private UserTwoRepository userTwoRepository;

    @Test
    public void testSave() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userOneRepository.save(new User("aa", "aa123456", "aa@qq.com", "aa", formattedDate));
        userOneRepository.save(new User("bb", "bb123456", "bb@qq.com", "bb", formattedDate));
        userTwoRepository.save(new User("cc", "cc123456", "cc@qq.com", "cc", formattedDate));
    }

    @Test
    public void testDelete() {
        userOneRepository.deleteAll();
        userTwoRepository.deleteAll();
    }

    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("ff", "ff123456", "ff@qq.com", "ff", formattedDate);
        userOneRepository.findAll();
        userTwoRepository.findById(3L);
        userTwoRepository.save(user);
        user.setId(2L);
        userOneRepository.delete(user);
        userOneRepository.count();
        userTwoRepository.findById(3L);
    }
}