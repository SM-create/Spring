package com.icia.test.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.test.dao.TestDAO;
import com.icia.test.dto.TestDTO;

@Service

public class TestService {

	@Autowired
	private TestDAO tdao;
	private ModelAndView mav;

	@Autowired
	private HttpSession session;
	
	//memberjoin 호출결과로 insert 성공 여부처리
	
	public ModelAndView memberJoin1(TestDTO member) {
		mav = new ModelAndView();
		
		// memeberJoin1 호출 결과를 받아서 insert 성공 여부에 따라 처리
		int insertResult=0;
		
		insertResult = tdao.memberJoin1(member);
		
		if(insertResult>0) {
			//성공시 memberlogin가 0보다 클경우
			mav.setViewName("memberlogin1");
		}else {
			// insertResult가 0일 경우
			mav.setViewName("joinfail");
		}
		
		return mav;
	}
	
	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<TestDTO> memberList = tdao.memberList();
		
		//memberList에 DB조회 결과를 담아서 memberList.jsp로 이동
		mav.addObject("memberList", memberList);
		mav.setViewName("memberList");
		
		return mav;
		
	}
	
	//member조회
	public ModelAndView memberView (String tid) {
		mav = new ModelAndView();
		
		TestDTO member =tdao.memberView(tid);
		
		mav.addObject("result", member);
		mav.setViewName("memberview");
		
		return mav;
		
	}
	
	
	//id 중복확인
	public String idCheck(String tid) {
		
		String checkResult = tdao.idCheck(tid);
		
		String result="";
		
		if(checkResult == null) {
			result ="ok";
		}else {
			result="no";
		}
		System.out.println("서비스클래스 체크 : "+result);
		return result;
		
	}
	
	
	public TestDTO memberViewAjax(String tid) {
		TestDTO member = tdao.memberView(tid);
		
		return member;
	}
	

	public ModelAndView memberLogin(TestDTO member) {

		mav = new ModelAndView();
		
		String loginId = tdao.memberLogin(member);
		
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("membermain");
		}else {
			mav.setViewName("memberlogin");
		}
		
		return mav;
	}

	public ModelAndView update() {

		mav = new ModelAndView();
		
		String loginId =(String) session.getAttribute("loginMember");
		
		TestDTO memberupdate =tdao.update(loginId);
		
		mav.addObject("member123", memberupdate);
		mav.setViewName("memberupdate");
			
		return mav;
	}
	
	public ModelAndView updateProcess(TestDTO member) {
		mav = new ModelAndView();
		int updateResult = tdao.updateProcess(member);
		// 수정 완료: membermain.jsp
		// 수정 실패: updatefail.jsp
		if(updateResult > 0) {
			mav.setViewName("membermain");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}
	
	
}












