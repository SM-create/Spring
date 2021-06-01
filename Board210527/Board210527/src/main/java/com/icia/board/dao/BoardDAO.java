<<<<<<< HEAD
package com.icia.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.pageDTO;

@Repository

public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;

	
	public int boardwrite(BoardDTO board){
		return sql.insert("bd.boardwrite", board);
	}	


	public List<BoardDTO> boardList() {
		
		return sql.selectList("bm.boardlist");
	}


	public void boardHits(int bnumber) {
		
		sql.update("bm.boardhits", bnumber);
	}


	public BoardDTO boardview(int bnumber) {
		return sql.selectOne("bm.boardview",bnumber);
	}


	public int updateprocess(BoardDTO board) {
		return sql.update("bm.boardupdate",board);
	}
	
	
	public int boardDelete(int bnumber) {

		return sql.delete("bm.boarddelete",bnumber);
	}


	public int listCount() {

		return sql.selectOne("bm.listcount");
	}


	public List<BoardDTO> boardPaging(pageDTO paging) {
		return sql.selectList("bm.boardpaging",paging);
	}


	public List<BoardDTO> boardSearch(Map<String, String> searchMap) {

		return sql.selectList("bm.boardsearch",searchMap	);
	}
	
	/*
	 * public void boardWriteFile(BoardDTO board) {
	 * 
	 * }
	 */

	
	

}
=======
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
>>>>>>> branch 'master' of https://github.com/SM-create/Spring.git
