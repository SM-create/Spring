package com.icia.test.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.test.dto.TestDTO;
import com.icia.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService ts;
	private ModelAndView mav;

	@Autowired
	private HttpSession session;

	// 회원가입
	@RequestMapping(value = "/joinpage1")
	public String joinpage() {
		return "memberjoin1";
	}

	/*
	 * @RequestMapping(value="/memberjoin") public ModelAndView
	 * memberjoin(@RequestParam("tid") String tid,
	 * 
	 * @RequestParam("tpassword") String password,
	 * 
	 * @RequestParam("tname") String tname,
	 * 
	 * @RequestParam("tpnumber") int tpnumber,
	 * 
	 * 프로필사진 추가
	 * 
	 * @RequestParam("temail") String teamail) { memberDTOmember = new
	 * T_memberDTO(); member.setTid(tid); member.setTpassword(tpassword);
	 * member.setTname(tname); member.setTpnumber(tpnumber);
	 * member.setTeamail(teamil);
	 * 
	 * mav = ts.T_member}
	 * 
	 * 
	 */

	@RequestMapping(value = "/memberjoin1")
	public ModelAndView memberjoin(@ModelAttribute TestDTO member) {
		mav = ts.memberJoin1(member);

		// 회원가입 완료시 로그인 페이지 출력
		return mav;
	}

	@RequestMapping(value = "/memberlist")
	public ModelAndView memberList() {
		
		mav = ts.memberList();

		return mav;
	}

	@RequestMapping(value = "/memberview")
	public ModelAndView memberView(@RequestParam(value="tid", required=false, defaultValue="0") String tid) {

		mav = ts.memberView(tid);

		return mav;
	}

	// 로그인 처리 메소드
	@RequestMapping(value = "/login")
	public ModelAndView memberLogin(@ModelAttribute TestDTO member) {
		System.out.println("login 메소드" + member.toString());
		mav = ts.memberLogin(member);
		return mav;
	}

	// 로그인 화면 출력 메소드
	@RequestMapping(value = "/loginpage")
	public String loginPage() {
		return "memberlogin1";
	}


	// 로그아웃 처리 메소드
	@RequestMapping(value = "/logout")
	public String logout() {
		// 로그아웃은 세션에 저장된 내용을 지운다는 개념
		session.invalidate();
		return "home";
	}

	// 회원정보 수정 처리 메소드 
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute TestDTO member) {
		mav = ts.updateProcess(member);
		return mav;
	}
	
	// 회원정보 수정 요청 메소드 
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ts.update();
		
		return mav;
	}

	// 아이디 중복확인
	@RequestMapping(value = "/idcheck")
	public @ResponseBody String idCheck(@RequestParam("tid") String tid) {
		System.out.println("idCheck 메소드 호출됨");
		System.out.println("입력 id값" + tid);
		String result = ts.idCheck(tid);

		return result;
	}

	// ajax로 상세조회
	@RequestMapping(value = "/memberviewajax")
	public @ResponseBody TestDTO memberViewAjax(@RequestParam("tid") String tid) {
		System.out.println("memberViewAjax 메소드 호출됨");
		System.out.println("전달 id값 " + tid);

		TestDTO member = ts.memberViewAjax(tid);

		System.out.println(member);

		return member;
	}

}
