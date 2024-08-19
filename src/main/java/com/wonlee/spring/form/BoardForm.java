package com.wonlee.spring.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardForm {
	public String userid;
	public String title;
	public String content;
	public String name;
	public int seq;
	public int view_cnt;
	public String write_date;
	private List<BoardForm> boardList;
	public String file_path;

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public List<BoardForm> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardForm> boardList) {
		this.boardList = boardList;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

}
