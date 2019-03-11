package com.liam.springboot.mybatisxml.param;

/**
 * @Author: Liam
 * @Date: 2019/2/26 21:54
 */
public class UserParam extends PageParam {
    private String userName;
    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
