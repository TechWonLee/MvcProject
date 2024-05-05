package com.wonlee.spring.mapper;

import com.wonlee.spring.User.UserInfo;
import com.wonlee.spring.User.UserList;
import com.wonlee.spring.form.LoginForm;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface UserMapper {
      public LoginForm loginCheck(LoginForm form);

      public List<UserList> getuserList();

      public UserInfo getuserinfo(String id);
}
