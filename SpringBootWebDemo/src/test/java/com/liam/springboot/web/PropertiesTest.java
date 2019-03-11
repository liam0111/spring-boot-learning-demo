package com.liam.springboot.web;

import com.liam.springboot.web.comm.LiamProperties;
import com.liam.springboot.web.comm.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * properties测试类
 *
 * @Author: Liam
 * @Date: 2018/12/5 17:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${liam.title}")
    private String title;
    @Resource
    private LiamProperties properties;
    @Resource
    private OtherProperties otherProperties;

    @Test
    public void testSingle() {
        Assert.assertEquals(title, "史靓");
    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title: " + properties.getTitle());
        System.out.println("description: " + properties.getDescription());
    }

    @Test
    public void testOther() throws Exception{
        System.out.println("title: " + otherProperties.getTitle());
        System.out.println("blog: " + otherProperties.getBlog());
    }
}
