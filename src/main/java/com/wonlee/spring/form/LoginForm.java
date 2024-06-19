package com.wonlee.spring.form;

import lombok.Data;

@Data
public class LoginForm {
	public String userid;
    public String password;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

   

    











}
