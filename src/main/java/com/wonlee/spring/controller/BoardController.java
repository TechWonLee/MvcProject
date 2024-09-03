package com.wonlee.spring.controller;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.File;
import com.wonlee.spring.User.UserInfo;
import com.wonlee.spring.form.BoardForm;
import com.wonlee.spring.service.BoardService;
import com.wonlee.spring.service.UserService;

import jdk.internal.org.jline.utils.Log;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService;

	/**
	 * 
	 * @param userid
	 * @param password
	 * @param model
	 * @param session
	 * @return 페이지
	 */

	@RequestMapping("/boardList.do")
	public String boardList(@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "password", required = false) String password, Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("userid");
		if (sessionId == null) {
			return "login/login";
		}

		List<BoardForm> boardform = boardService.boardList();
		if (boardform == null) {
			return "error/error";
		}
		UserInfo userinfo = userService.getuserinfo(userid);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("boardList", boardform);

		return "board/boardList";
	}

	/**
	 * 
	 * @param userid
	 * @param model
	 * @param session
	 * @return 페이지
	 */
	@RequestMapping("/boardWriteView.do")
	public String boardWriteView(@RequestParam("userid") String userid, Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("userid");
		if (sessionId == null) {
			return "login/login";
		}

		UserInfo userinfo = userService.getuserinfo(userid);

		model.addAttribute("userinfo", userinfo);

		return "board/boardWrite";
	}

	@RequestMapping("/excerciseBook.do")
	public String excerciseBook(@RequestParam("userid") String userid, Model model, HttpSession session) {

		String sessionId = (String) session.getAttribute("userid");
		if (sessionId == null) {
			return "login/login";
		}

		UserInfo userinfo = userService.getuserinfo(userid);

		model.addAttribute("userinfo", userinfo);

		return "excercise/excersice";
	}

	/**
	 * 
	 * @param form
	 * @param model
	 * @param session
	 * @param redirectAttributes
	 * @return 페이지
	 */

	@RequestMapping("boardWrite.do")
	public String boardWrite(@ModelAttribute("boardForm") BoardForm form, Model model, HttpSession session,
			RedirectAttributes redirectAttributes, HttpServletRequest request,
			@RequestParam(value = "files", required = false) List<MultipartFile> multipartFile) {

		System.out.println("file  : :: " + multipartFile);

		String sessionId = (String) session.getAttribute("userid");
		if (sessionId == null) {
			return "login/login";
		}

		if (multipartFile == null) {
			int isSucess = boardService.boardWrite(form);
		} else {
			//저장할 파일경로 정하기.
			String fileRoot;
			String contextRoot = request.getSession().getServletContext().getRealPath("/");
			fileRoot = contextRoot + "resources/upload/";

			// 파일 디렉토리가 없을 경우 생성
			File dir = new File(fileRoot);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			try {
				for (MultipartFile file : multipartFile) {
					if (!file.isEmpty()) {

						System.out.println(fileRoot);

						String originalFileName = file.getOriginalFilename();// 오리지날 파일명
						String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자
						String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

						// 파일 목적지
						File targetFile = new File(fileRoot + savedFileName);

						// 저장할 타겟 파일 디렉토리
						file.transferTo(targetFile);
						form.setFile_path(fileRoot + savedFileName);
						int isSucess = boardService.boardWrite(form);
						// You can save file details in the database here if needed (e.g., file name,
						// path, etc.)
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "error/error";
			}

		}
		redirectAttributes.addAttribute("userid", form.getUserid());
		return "redirect:/board/boardList.do";
	}

	/**
	 * 
	 * @param seq
	 * @param model
	 * @param session
	 * @return 페이지
	 */

	@RequestMapping("boardView.do")
	public String boardView(@RequestParam("seq") int seq, Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("userid");
		if (sessionId == null) {
			return "login/login";
		}

		// 조회수 update
		int success = boardService.boardViews(seq);
		BoardForm boardform = boardService.boardView(seq);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("board", boardform);

		if (success == 0) {
			return "error/error";
		}

		if (boardform == null) {
			return "error/error";
		}
		return "board/boardView";
	}

	// 비동기 처리

	/**
	 * 
	 * @param form
	 * @param session
	 * @param model
	 * @return JSONObject
	 */

	@ResponseBody
	@PostMapping("/boardUpdate.do")
	public JSONObject boardUpdate(@RequestBody BoardForm form, HttpSession session, Model model) {
		String sessionId = (String) session.getAttribute("userid");

		JSONObject jsonObject = new JSONObject();

		if (sessionId == null) {
			session.invalidate();
			jsonObject.put("sessionReset", "0");
			jsonObject.put("message", "세션이 종료되었습니다. \n로그인이 필요합니다.");

			return jsonObject;
		} else if (!sessionId.equals(form.getUserid())) {
			jsonObject.put("message", "작성자가 일치하지 않습니다.");
			return jsonObject;
		} else {
			try {
				int success = boardService.boardUpdate(form);

				jsonObject.put("message", "게시글이 성공적으로 업데이트되었습니다.");
				return jsonObject;
			} catch (Exception e) {
				Log.error("Update Error{}", e);
				jsonObject.put("message", "게시글 업데이트 중 오류가 발생했습니다.");
				return jsonObject;
			}
		}
	}

	/**
	 * 
	 * @param userid
	 * @param seq
	 * @param session
	 * @param model
	 * @return JSONObject
	 */
	@ResponseBody
	@PostMapping("/boardDelete.do")
	public JSONObject boardDelete(@RequestParam("userid") String userid, @RequestParam("seq") String seq,
			HttpSession session, Model model) {
		String sessionId = (String) session.getAttribute("userid");

		JSONObject jsonObject = new JSONObject();

		if (sessionId == null) {
			session.invalidate();
			jsonObject.put("sessionReset", "0");
			jsonObject.put("message", "세션이 종료되었습니다. \n로그인이 필요합니다.");

			return jsonObject;
		} else if (!sessionId.equals(userid)) {
			jsonObject.put("message", "작성자가 일치하지 않습니다.");
			return jsonObject;
		} else {
			try {
				int success = boardService.boardDelete(userid, seq);

				jsonObject.put("message", "게시글이 성공적으로 삭제되었습니다.");
				return jsonObject;
			} catch (Exception e) {
				Log.error("Update Error{}", e);
				jsonObject.put("message", "게시글 삭제 중 오류가 발생했습니다.");
				return jsonObject;
			}
		}
	}
	@RequestMapping("chat-popup.do")
	public String Chat(Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("userid");
		if (sessionId == null) {
			return "login/login";
		}
		model.addAttribute("sessionId", sessionId);
		
		return "chat/chat-popup";
	}
	
}
