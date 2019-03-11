package com.liam.springboot.jpa.repository;

import com.liam.springboot.jpa.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * @Author: Liam
 * @Date: 2019/3/2 19:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Resource
    private UserRepository userRepository;

    @Test
    public void test() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userRepository.save(new User("aa", "aa123456", "aa@qq.com", "aa", formattedDate));
        userRepository.save(new User("bb", "bb123456", "bb@qq.com", "bb", formattedDate));
        userRepository.save(new User("cc", "cc123456", "cc@qq.com", "cc", formattedDate));
        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@qq.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));
    }

    @Test
    public void testBaseQuery() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        User user = new User("ff", "ff123456", "ff@qq.com", "ff", formattedDate);
        userRepository.findAll();
        userRepository.findById(3L);
        userRepository.save(user);
        user.setId(2L);
        userRepository.delete(user);
        userRepository.count();
        userRepository.existsById(3L);
    }

    @Test
    public void testCustomSql() {
        userRepository.modifyById("liam", 3L);
        userRepository.deleteById(3L);
        userRepository.findByEmail("ff@qq.com");
    }

    @Test
    public void testPageQuery() {
        int page = 1, size = 2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        userRepository.findALL(pageable);
        userRepository.findByNickName("aa", pageable);
    }
}
