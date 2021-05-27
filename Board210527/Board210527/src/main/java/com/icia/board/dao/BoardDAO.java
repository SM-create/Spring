package com.icia.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository

public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<BoardDTO> boardlist(){
		return sql.selectlist("bd.boardlist");
	}
	
	public int boardlist(){
		return sql.selectone("bd.boardwrite", board);
	}
	
	

}
