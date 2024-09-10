package com.wonlee.spring.service;

import com.wonlee.spring.form.LoginForm;
import com.wonlee.spring.user.UserInfo;
import com.wonlee.spring.user.UserList;

import java.util.List;

public interface UserService {
     public LoginForm loginCheck(LoginForm form);

     public List<UserList> getUserList();

     public UserInfo getuserinfo(String id);
}
