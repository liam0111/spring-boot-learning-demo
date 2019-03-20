package com.liam.springboot.dubboprovider.service;

import com.liam.springboot.dubboapi.User;

/**
 * @Author: Liam
 * @Date: 2019/3/13 18:56
 */
public class UserImpl implements User {
    private String name;
    private String password;

    public UserImpl(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
