package com.wonlee.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

			suceess = boardMapper.boardWrite(form);

		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
			return suceess;
		}
		return suceess;

	}

	public List<BoardForm> boardList() {
		try {
			return boardMapper.boardList();
		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
			return null;
		}
	}

	public BoardForm boardView(int seq) {

		try {
			
			return boardMapper.boardView(seq);

		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional
	public int boardViews(int seq) {
		try {
			
			return boardMapper.boardViews(seq);

		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
		}
		return 0;
	}
	


	public int boardUpdate(BoardForm form) {
		int suceess = 1;
		try {
			boardMapper.boardUpdate(form);
			return suceess;

		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
			suceess = 0;
			return suceess;
		}
	}

	
	public int boardDelete(String userid, String seq) {
		int suceess = 1;
		try {
			 boardMapper.boardDelete(userid, seq);
			 return suceess;

		} catch (Exception e) {
			log.error("loginCheck Error {}", e);
			e.printStackTrace();
			suceess =0;
			return suceess;
		}
	}
	

}
