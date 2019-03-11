package com.liam.springboot.mybatisxml.mapper;

import com.liam.springboot.mybatisxml.enums.UserSexEnum;
import com.liam.springboot.mybatisxml.model.User;
import com.liam.springboot.mybatisxml.param.UserParam;
import com.liam.springboot.mybatisxml.result.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/2/26 21:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testUser() {
        userMapper.insert(new User("aaa", "aaa123", UserSexEnum.MAN));
        userMapper.insert(new User("bbb", "bbb123", UserSexEnum.WOMAN));
        int count = userMapper.delete(2L);
        User user = userMapper.getOne(1L);
        user.setNickName("liam");
        userMapper.update(user);
        List<User> users = userMapper.getAll();
    }

    @Test
    public void testPage() {
        UserParam userParam = new UserParam();
        userParam.setUserSex("MAN");
        userParam.setCurrentPage(0);
        List<User> users = userMapper.getList(userParam);
        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);
        System.out.println(page);
    }
}
