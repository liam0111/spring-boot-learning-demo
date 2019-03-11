package com.liam.springboot.jpathymeleaf.repository;

import com.liam.springboot.jpathymeleaf.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: Liam
 * @Date: 2019/3/6 22:35
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u")
    Page<User> findList(Pageable pageable);

    User findById(long id);

    User findByUserName(String userName);

    @Override
    void deleteById(Long id);
}
