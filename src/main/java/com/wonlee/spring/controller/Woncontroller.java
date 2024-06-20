package com.wonlee.spring.controller;


import com.wonlee.spring.User.UserInfo;
import com.wonlee.spring.User.UserList;
import com.wonlee.spring.service.UserService;
import com.wonlee.spring.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
public class Woncontroller {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String test() {
        return "login";
    }

    @RequestMapping("/login_check.do")
        public ModelAndView loginCheck(HttpServletRequest request, @ModelAttribute("loginForm") LoginForm form, Model model) throws Exception {
        boolean islogin = true;
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1800);

        //session.getId();
        // servlet 으로 파라미터 받기
        //String id = request.getParameter("userid");
        //String pw = request.getParameter("password");

        //<form:form> 으로 파라미터 받기
        String id = form.getUserid();
        //form.setPassword(pw);
        //없어도 되는 코드임 login 상세보기 추가
        /*model.addAttribute("loginch",islogin);
        model.addAttribute("form",form);*/
    
        LoginForm loginch = userService.loginCheck(form);
        
        if(loginch == null || loginch.getUserid() == null) {
            islogin = false;
            session.invalidate();
            model.addAttribute("islogin",islogin);
            mav.setViewName("login");
            return mav;
        }
        model.addAttribute(loginch);
        List<UserList> ulist= userService.getUserList();
        model.addAttribute("userList",ulist);
        mav.setViewName("userList");

        return mav ;
    }

    @RequestMapping(value = "/view/{id}", method= RequestMethod.GET)
    public ModelAndView userView (@PathVariable("id") String id, Model model) throws Exception {
        ModelAndView mav = new ModelAndView();
        UserInfo  userinfo = userService.getuserinfo(id);
        String datetime = userinfo.getJoin_date();
        String joindate = datetime.substring(0,16);
        userinfo.setJoin_date(joindate);
        model.addAttribute("userInfo",userinfo);
        mav.setViewName("userView");
        return mav ;
    }



}
