package com.wonlee.spring.service;

import com.wonlee.spring.mapper.UserMapper;
import com.wonlee.spring.user.UserInfo;
import com.wonlee.spring.user.UserList;
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

    
    public LoginForm loginCheck(LoginForm form)   {
        try{
        LoginForm checkform = new LoginForm();
        checkform = userMapper.loginCheck(form);
       return checkform;
       
        } catch (Exception e) {
            log.error("loginCheck Error {}" ,e);
            e.printStackTrace();
            //null을 return하여 로그인을 막음
            LoginForm checkform = null;
            return checkform;
        }
    }

 
    public List<UserList> getUserList() {
        try {
            List<UserList> userList;
            userList = userMapper.getuserList();
            return userList;
        }catch (Exception e) {
            log.error("getUserList Error {}" ,e);
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
            log.error(" getuserinfo Error {}", e);
            e.printStackTrace();
            UserInfo userInfo = null;
            return userInfo;
        }
    }
}
