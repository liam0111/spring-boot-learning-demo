package com.liam.springboot.jpa.service;

import com.liam.springboot.jpa.model.UserDetail;
import com.liam.springboot.jpa.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: Liam
 * @Date: 2019/3/2 21:51
 */
public interface UserDetailService {
    public Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
