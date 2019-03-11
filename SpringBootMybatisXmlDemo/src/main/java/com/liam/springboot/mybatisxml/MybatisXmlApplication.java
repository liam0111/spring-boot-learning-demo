package com.liam.springboot.mybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liam.springboot.mybatisxml.mapper")
public class MybatisXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlApplication.class, args);
    }

}
