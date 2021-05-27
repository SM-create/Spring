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
		
		//�۾��� ����: ������ (��� ����� ����ϴ� ��Ʈ�ѷ��� �ּҸ� ��û�ؾ���.)
		//�۾��� ����: boardwrite.jsp�� ���.
		if(writeResult > 0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("boardwrite");
		}
		
		return bav;
		
	}
	
}
