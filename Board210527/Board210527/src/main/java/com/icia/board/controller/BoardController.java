package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
//	@Autowired
//	private httpSession session;

	
//	@RequestMapping(value="/whitepage")
//	public ModelAndView boardwrite (@RequestParam("btitle") String btitle,
//									@RequestParam("bpassword") String bpassword,
//									@RequestParam("bwriter") String bwriter,
//									@RequestParam("bcontents") String bcontents) {
//		BoardDTO board = new BoardDTO();
//		board.setBtitle(btitle);
//		board.setBpassword(bpassword);
//		board.setBwriter(bwriter);
//		board.setBcontents(bcontents);
//		
//		bav=bs.boardwrite(board);
//		
//		return bav;
//		
//	}
//	
	
	
	//글쓰기 화면을 띄우는 메소드
	@RequestMapping (value="/whitepage")
	public String whitepage() {
		return "boardwhite";
	}
	
	//글쓰기 처리를 하는 메소드
	@RequestMapping (value="/boardwrite")
	public ModelAndView boardwrite(@ModelAttribute BoardDTO board) {
		mav=bs.boardlist(board);
		return null;
	}
	
	
//		@RequestMapping(value="/insert")
//		public void insert(@ModelAttribute BoardDTO dto) {
//			
//			System.out.println(dto.toString());
//			
//		}
		
//		@RequestMapping(value="/select")
//		public ModelAndView select() {
//			bav=bs.select();
//			return bav;
//		}
	
}
