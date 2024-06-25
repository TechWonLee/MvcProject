package com.wonlee.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wonlee.spring.User.UserInfo;
import com.wonlee.spring.form.BoardForm;
import com.wonlee.spring.service.BoardService;
import com.wonlee.spring.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;

	@RequestMapping("/boardList.do")
	public String boardList(@RequestParam("userid") String userid, @RequestParam("password") String password,
			Model model) {

		List<BoardForm> boardform = boardService.boardList();
		if (boardform == null) {
			return "error/error";
		}
		UserInfo userinfo = userService.getuserinfo(userid);

		model.addAttribute("userinfo", userinfo);
		model.addAttribute("boardList", boardform);

		return "board/boardList";
	}

	@RequestMapping("/boardWriteView.do")
	public String boardWriteView(@RequestParam("userid") String userid, Model model) {

		UserInfo userinfo = userService.getuserinfo(userid);

		model.addAttribute("userinfo", userinfo);

		return "board/boardWrite";
	}

	@RequestMapping("boardWrite.do")
	public String boardWrite(@ModelAttribute("boardForm") BoardForm form, Model model) {

		int isSucess = boardService.boardWrite(form);
		if (isSucess == 1) {
			List<BoardForm> boardList = boardService.boardList();
			if (boardList == null) {
				return "error/error";
			}
			UserInfo userinfo = userService.getuserinfo(form.getUserid());

			model.addAttribute("userinfo", userinfo);
			model.addAttribute("boardList", boardList);
			return "board/boardList";
		}
		return "error/error";
	}

	@RequestMapping("boardView.do")
	public String boardView(@RequestParam("seq") String seq, Model model) {

		BoardForm boardform = boardService.boardView(seq);
		model.addAttribute("board", boardform);
		if (boardform == null) {
			return "error/error";
		}
		return "board/boardView";
	}

}
