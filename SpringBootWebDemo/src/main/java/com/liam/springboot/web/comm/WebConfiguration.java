package com.liam.springboot.web.comm;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将自定义过滤器加入过滤链
 *
 * @Author: Liam
 * @Date: 2018/12/4 21:57
 */
@Configuration
public class WebConfiguration {
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(6);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean test2FilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter2());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("MyFilter2");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
