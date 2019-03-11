package com.liam.springboot.jpa.repository;

import com.liam.springboot.jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Liam
 * @Date: 2019/3/2 21:47
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
