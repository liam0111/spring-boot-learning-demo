package com.liam.springboot.mybatisannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liam.springboot.mybatisannotation.mapper")
public class MybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAnnotationApplication.class, args);
    }

}
