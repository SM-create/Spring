package com.icia.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired 
	private MemberService ms;
	
	private ModelAndView mav;
	
	// home.jsp에서 joinpage 링크클릭 요청을 하면 
	// 아래 메소드가 호출됨 
	@RequestMapping(value="/joinpage")
	public String joinPage() {
		return "memberjoin";
	}
	
//	@RequestMapping(value="/memberjoin")
//	public ModelAndView memberJoin(@RequestParam("mid") String mid, 
//									@RequestParam("mpassword") String mpassword,
//									@RequestParam("mname") String mname, 
//									@RequestParam("memail") String memail) {
//		MemberDTO member = new MemberDTO();
//		member.setMid(mid);
//		member.setMpassword(mpassword);
//		member.setMname(mname);
//		member.setMemail(memail);
//		
//		mav = ms.memberJoin(member);
//
//		// 회원가입이 완료되면 로그인 페이지가 출력되도록 
//		return mav;
//	}
	
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		mav = ms.memberJoin(member);

		// 회원가입이 완료되면 로그인 페이지가 출력되도록 
		return mav;
	}
	
	@RequestMapping(value="/memberlist")
	public ModelAndView memberList() {
		mav = ms.memberList();
		
		return mav;
	}
	
	@RequestMapping(value="/memberview")
	public ModelAndView memberView(@RequestParam("mid") String mid) {
		mav = ms.memberView(mid);
		return mav;
	}
	
	
	//아이디 중복확인 메소드
	@RequestMapping (value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid")String mid) {
			System.out.println("idCheck 메소드 호출됨");
			System.out.println("입력 id값"+mid);
			String result =ms.idCheck(mid);
			
			return result;
	}
	
	// ajax로 상세조회
	@RequestMapping(value="/memberviewajx")
	public @ResponseBody memberDTO  memberViewAjax(
							@Requestparam("mid")String mid) {
		System.out.println("memberviewajx메호스 호출");
		System.out.println("전달 id값"+mid);
		MemberDTO member =ms.memberView(mid);
		return member;
		
		
	}
																		
}





