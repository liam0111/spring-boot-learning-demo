package com.liam.springboot.multimybatisannotation.mapper;

import com.liam.springboot.multimybatisannotation.enums.UserSexEnum;
import com.liam.springboot.multimybatisannotation.mapper.one.User1Mapper;
import com.liam.springboot.multimybatisannotation.mapper.two.User2Mapper;
import com.liam.springboot.multimybatisannotation.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liam
 * @Date: 2019/2/28 22:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private User1Mapper user1Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void testInsert() {
        user1Mapper.insert(new User("aa111", "a123456", UserSexEnum.MAN));
        user1Mapper.insert(new User("bb111", "b123456", UserSexEnum.WOMAN));
        user2Mapper.insert(new User("cc222", "b123456", UserSexEnum.MAN));
    }
}
