package com.liam.springboot.jsp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 外部容器运行项目必需
 *
 * @Author: Liam
 * @Date: 2018/12/5 21:31
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JspApplication.class);
    }
}
