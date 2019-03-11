package com.liam.springboot.web.comm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Properties对象，用户读取自定义配置文件
 *
 * @Author: Liam
 * @Date: 2018/12/5 18:26
 */
@Component
@ConfigurationProperties(prefix = "other")
@PropertySource("classpath:other.properties")
public class OtherProperties {
    private String title;
    private String blog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
