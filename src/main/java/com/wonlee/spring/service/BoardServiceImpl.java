package com.wonlee.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wonlee.spring.form.BoardForm;
import com.wonlee.spring.mapper.BoardMapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BoardServiceImpl implements BoardService {

	private final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardMapper boardMapper;

	public int boardWrite(BoardForm form) {
		int suceess = 1;
		try {

			BoardForm boardFrom = new BoardForm();

			suceess = boardMapper.boardWrite(form);

		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
			return suceess;
		}
		return suceess;

	}
	
	public List<BoardForm> boardList() {
		return boardMapper.boardList();
	}
	

}
