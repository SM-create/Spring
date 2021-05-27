package com.icia.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;

@Service

public class BoardService {

	@Autowired 
	
	private BoardDAO bdao;
	
	private ModelAndView mav;
	
	
	public ModelAndView boardwrite(BoardDTO board) {
		mav= new ModelAndView();
		int witeResult= bdao.boardwrite(board);
		
		//글쓰기 성공: 목록출력 (목록 출력을 담당하는 컨트롤러의 주소를 요청해야함.)
		//글쓰기 실패: boardwrite.jsp를 띄움.
		if(writeResult > 0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("boardwrite");
		}
		
		return bav;
		
	}
	
}
