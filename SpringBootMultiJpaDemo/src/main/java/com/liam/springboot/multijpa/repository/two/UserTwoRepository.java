package com.liam.springboot.multijpa.repository.two;

import com.liam.springboot.multijpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Liam
 * @Date: 2019/3/6 19:23
 */
public interface UserTwoRepository extends JpaRepository<User, Long> {
    User findById(long id);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
}