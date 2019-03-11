package com.liam.springboot.mybatisannotation.mapper;

import com.liam.springboot.mybatisannotation.enums.UserSexEnum;
import com.liam.springboot.mybatisannotation.model.User;
import com.liam.springboot.mybatisannotation.param.UserParam;
import com.liam.springboot.mybatisannotation.result.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liam
 * @Date: 2019/2/28 21:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));
    }

    @Test
    public void testQuery() {
        Map param = new HashMap();
        param.put("username", "aa");
        param.put("user_sex", "MAN");
        List<User> users = userMapper.getListByNameAndSex(param);
        System.out.println("testQuery:" + users.toString());
    }

    @Test
    public void testUpdate() {
        User user = userMapper.getOne(5L);
        System.out.println("user :" + user.toString());
        user.setNickName("liam");
        user.setUserName("liam");
        userMapper.updateUser(user);
    }

    @Test
    public void testPage() {
        UserParam userParam = new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setCurrentPage(0);
        List<User> users = userMapper.getList(userParam);
        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);
        System.out.println("page === " + page);
    }
}
