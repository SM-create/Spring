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
	
	//memberjoin ȣ������ insert ���� ����ó��
	
	public ModelAndView memberJoin1(TestDTO member) {
		mav = new ModelAndView();
		
		// memeberJoin1 ȣ�� ����� �޾Ƽ� insert ���� ���ο� ���� ó��
		int insertResult=0;
		
		insertResult = tdao.memberJoin1(member);
		
		if(insertResult>0) {
			//������ memberlogin�� 0���� Ŭ���
			mav.setViewName("memberlogin1");
		}else {
			// insertResult�� 0�� ���
			mav.setViewName("joinfail");
		}
		
		return mav;
	}
	
	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<TestDTO> memberList = tdao.memberList();
		
		//memberList�� DB��ȸ ����� ��Ƽ� memberList.jsp�� �̵�
		mav.addObject("memberList", memberList);
		mav.setViewName("memberList");
		
		return mav;
		
	}
	
	//member��ȸ
	public ModelAndView memberView (String tid) {
		mav = new ModelAndView();
		
		TestDTO member =tdao.memberView(tid);
		
		mav.addObject("result", member);
		mav.setViewName("memberview");
		
		return mav;
		
	}
	
	
	//id �ߺ�Ȯ��
	public String idCheck(String tid) {
		
		String checkResult = tdao.idCheck(tid);
		
		String result="";
		
		if(checkResult == null) {
			result ="ok";
		}else {
			result="no";
		}
		System.out.println("����Ŭ���� üũ : "+result);
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
		// ���� �Ϸ�: membermain.jsp
		// ���� ����: updatefail.jsp
		if(updateResult > 0) {
			mav.setViewName("membermain");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}
	
	
}












