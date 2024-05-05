package com.wonlee.spring.service;

import com.wonlee.spring.User.UserInfo;
import com.wonlee.spring.User.UserList;
import com.wonlee.spring.form.LoginForm;

import java.util.List;

public interface UserService {
     public LoginForm loginCheck(LoginForm form);

     public List<UserList> getUserList();

     public UserInfo getuserinfo(String id);
}
