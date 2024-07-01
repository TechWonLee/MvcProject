package com.wonlee.spring.service;

import java.util.List;

import com.wonlee.spring.form.BoardForm;

public interface BoardService {
	
	public int boardWrite(BoardForm form);
	
	public List<BoardForm> boardList();
	
	public BoardForm boardView(int seq);
	
	public int boardUpdate(BoardForm form);
	
	public int boardDelete(String userid, String seq);
	
	public int boardViews(int seq);
	
	

}
