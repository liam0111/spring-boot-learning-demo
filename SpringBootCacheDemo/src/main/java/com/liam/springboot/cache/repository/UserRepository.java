package com.liam.springboot.cache.repository;

import com.liam.springboot.cache.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Liam
 * @Date: 2019/3/8 19:31
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

    List<User> findByNickname(String nickname);
}
