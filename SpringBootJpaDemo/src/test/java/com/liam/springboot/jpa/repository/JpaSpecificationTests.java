package com.liam.springboot.jpa.repository;

import com.liam.springboot.jpa.model.UserDetail;
import com.liam.springboot.jpa.param.UserDetailParam;
import com.liam.springboot.jpa.service.UserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Liam
 * @Date: 2019/3/2 23:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaSpecificationTests {
    @Resource
    private UserDetailService userDetailService;

    @Test
    public void testFindByCondition() {
        int page = 0, size = 10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        UserDetailParam param = new UserDetailParam();
        param.setIntroduction("程序员");
        param.setMinAge(10);
        param.setMaxAge(30);
        Page<UserDetail> page1 = userDetailService.findByCondition(param, pageable);
        for (UserDetail userDetail : page1) {
            System.out.println("userDetail: " + userDetail.toString());
        }
    }
}
