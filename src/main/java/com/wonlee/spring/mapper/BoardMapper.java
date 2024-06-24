package com.wonlee.spring.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.wonlee.spring.form.BoardForm;



@MapperScan
public interface BoardMapper {
	public int boardWrite(BoardForm form);
	public List<BoardForm> boardList();

}
