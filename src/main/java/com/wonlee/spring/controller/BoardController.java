package com.wonlee.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wonlee.spring.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
	 @Autowired
	    private UserService userService;
	 
	 @RequestMapping("/boardList.do")
	    public String boardList(@RequestParam("userid")String userid, @RequestParam("password")String password) {
		 
		 System.out.println("userid : : :"+userid);
		 System.out.println("password : : :"+password);
		 
		 
		 
	        return "board/boardList";
	    }

}
