package com.wonlee.spring.service;

import com.wonlee.spring.User.UserInfo;
import com.wonlee.spring.User.UserList;
import com.wonlee.spring.mapper.UserMapper;

import com.wonlee.spring.form.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService  {
private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginForm loginCheck(LoginForm form)   {
        try{
        LoginForm checkform = new LoginForm();
        checkform = userMapper.loginCheck(form);
       return checkform;
        } catch (Exception e) {
            log.error("Error 발생 {}" ,e);
            e.printStackTrace();
            //그냥 null을 return하는게 효율적임
            LoginForm checkform = null;
            return checkform;
        }
    }

    @Override
    public List<UserList> getUserList() {
        try {
            List<UserList> userList;
            userList = userMapper.getuserList();
            return userList;
        }catch (Exception e) {
            log.error("Error 발생 {}" ,e);
            e.printStackTrace();
            List<UserList> userList = null;
            return userList;

        }
    }
    public UserInfo getuserinfo(String id) {
        try {
            UserInfo userinfo;
            userinfo = userMapper.getuserinfo(id);
            return userinfo;

        } catch (Exception e) {
            log.error("Error 발생 {}", e);
            e.printStackTrace();
            UserInfo userInfo = null;
            return userInfo;
        }
    }
}
