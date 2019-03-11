package com.liam.springboot.jpa.repository;

import com.liam.springboot.jpa.model.UserDetail;
import com.liam.springboot.jpa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/3/2 21:49
 */
public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail, Long> {
    UserDetail findByHobby(String hobby);

    @Query("select u.userName as userName, u.email as email, d.introduction as introduction, d.hobby as hobby from User u, " +
            "UserDetail d where u.id=d.userId and d.hobby = ?1")
    List<UserInfo> findUserInfo(String hobby);
}
