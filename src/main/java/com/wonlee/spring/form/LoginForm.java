package com.wonlee.spring.form;

import lombok.Data;

@Data
public class LoginForm {


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String userid;
    public String passwd;












}
