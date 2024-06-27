package com.wonlee.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public String boardView(@RequestParam("seq") int seq, Model model) {

		BoardForm boardform = boardService.boardView(seq);
		model.addAttribute("board", boardform);
		if (boardform == null) {
			return "error/error";
		}
		return "board/boardView";
	}
	
	@ResponseBody
	@PostMapping("/boardUpdate.do")
	public JSONObject boardUpdate(@RequestBody BoardForm form, HttpSession session, Model model) {
	    String userid = (String) session.getAttribute("userid");

	    JSONObject jsonObject = new JSONObject();
	    
	    if (userid == null) {
	        session.invalidate();
	        jsonObject.put("sessionReset", "0");
	        jsonObject.put("message", "로그인이 필요합니다.");
	       
	        return jsonObject;
	    } else if (!userid.equals(form.getUserid())) {
	    	jsonObject.put("message", "작성자가 일치하지 않습니다.");
	        return jsonObject;
	    } else {
	        try {
	            boardService.boardUpdate(form);
	            jsonObject.put("message", "게시글이 성공적으로 업데이트되었습니다.");
	           
	            return jsonObject;
	        } catch (Exception e) {
	        	jsonObject.put("message", "게시글 업데이트 중 오류가 발생했습니다.");
	            return jsonObject;
	        }
	    }
	}

}
	

