package com.liam.springboot.multimybatisxml.mapper;

import com.liam.springboot.multimybatisxml.enums.UserSexEnum;
import com.liam.springboot.multimybatisxml.mapper.one.User1Mapper;
import com.liam.springboot.multimybatisxml.mapper.two.User2Mapper;
import com.liam.springboot.multimybatisxml.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/2/28 15:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class User1MapperTest {
    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void testInsert() throws Exception {
        user1Mapper.insert(new User("aaaaa", "123456", UserSexEnum.MAN));
        user1Mapper.insert(new User("bbbbb", "123456", UserSexEnum.WOMAN));
        user2Mapper.insert(new User("ccccc", "123456", UserSexEnum.MAN));
    }
}
