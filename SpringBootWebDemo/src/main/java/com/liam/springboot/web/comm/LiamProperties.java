package com.liam.springboot.web.comm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties对象，用于读取多个配置
 *
 * @Author: Liam
 * @Date: 2018/12/5 18:10
 */
@Component
@ConfigurationProperties(prefix = "liam")
public class LiamProperties {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
