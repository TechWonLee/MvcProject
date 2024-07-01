package com.wonlee.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.wonlee.spring.form.BoardForm;



@MapperScan
public interface BoardMapper {
	public int boardWrite(BoardForm form);
	public List<BoardForm> boardList();
	public BoardForm boardView(int seq);
	public int boardUpdate(BoardForm form);
	public int boardDelete(@Param("userid")String userid, @Param("seq")String seq);
	
	public int boardViews(int seq);

}
