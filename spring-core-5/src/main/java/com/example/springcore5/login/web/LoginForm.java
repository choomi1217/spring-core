package com.example.springcore5.login.web;

import lombok.Getter;

@Getter
public class LoginForm {

    private String loginId;
    private String password;

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
