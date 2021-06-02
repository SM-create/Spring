package com.icia.test.service;

import java.util.List;

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
	
	//memberjoinȣ������ insert ���� ����ó��
	public ModelAndView memberJoin(TestDTO test) {
		mav = new ModelAndView();
		
		int insertResult=0;
		insertResult = tdao.memberJoin(test);
		if(insertResult>0) {
			mav.setViewName("memberlogin");
		}else {
			mav.setViewName("joinfail");
		}
		
		return mav;
	}
	
	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<TestDTO> memberList = tdao.memberList();
		
		//memberList�� DB��ȸ ����� ��Ƽ� memberList.jsp�� �̵�
		mav.addObject("memberList", memberList);
		mav.addObject("memberList");
		
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
}
