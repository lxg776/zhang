package com.zheng.cpw.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserPassTypeToken extends UsernamePasswordToken {


    public static final String NO_CHECK_PASSWORD="0";
    public static final String CHECK_PASSWORD="1";


    String doType =CHECK_PASSWORD;

    public UserPassTypeToken(final String username, final String password) {
        super(username, password != null ? password.toCharArray() : null, false, null);
    }


    public String getDoType() {
        return doType;
    }

    public void setDoType(String doType) {
        this.doType = doType;
    }
}
