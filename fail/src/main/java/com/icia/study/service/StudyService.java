package com.icia.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;
	
	// ������ ����ϱ� ���� ���� ��ü ���� 
	@Autowired
	private HttpSession session;
	
	public ModelAndView memberJoin(MemberDTO member) {
		mav = new ModelAndView();
		
		// memberJoin ȣ�� ����� �޾Ƽ� insert ���� ���ο� ���� ó�� 
		int insertResult = 0;
		insertResult = mdao.memberJoin(member);
		if(insertResult > 0) {
			// insertResult �� 0���� ũ�ٴ� ���� insert�� �����ߴٴ� �ǹ��̱� ������ ȸ�������� �Ϸ�Ȱ����� �Ǵ� 
			mav.setViewName("memberlogin");
		} else { 
			// insertResult �� 0�̶�� �ǹ̴� insert�� �����ߴٴ� �ǹ�
			mav.setViewName("joinfail");
		}
		
		return mav;
	}

	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<MemberDTO> memberList = mdao.memberList();
		
		// memberList�� DB ��ȸ ����� ��Ƽ� memberlist.jsp�� �̵� 
		mav.addObject("memberList", memberList);
		mav.setViewName("memberlist1");
		
		return mav;
	}

	public ModelAndView memberView(String mid) {
		mav = new ModelAndView();
		
		// �Ѹ� ȸ���� ���� ������ �ʿ��ϱ� ������ DTO Ÿ���� ��ü�� ������ ����. 
		MemberDTO member = mdao.memberView(mid);
		
		// DB ��ȸ ����� member�� �޾Ұ�.. 
		// member�� ��Ƽ� memberview.jsp�� ������. 
		mav.addObject("result", member);
		mav.setViewName("memberview");
		
		return mav;
	}

	public ModelAndView memberLogin(MemberDTO member) {
		/*
		 * �α��� ó�� ���� ���� 
		 * 	����ڰ� memberlogin.jsp���� �Է��� ���̵�, ����� ȸ�������� �� DB�� ����� ���̵�, ����� ��ġ�ϴ����� 
		 * 	�Ǵ��Ͽ� ��ġ�ϸ� �α��� ����, ��ġ���� ������ �α��� ���з� ó�� 
		 */
		mav = new ModelAndView();
		
		String loginId = mdao.memberLogin(member);
		
		// loginId�� ���� �ִٸ� ���̵�, ����� ��� �¾Ҵٴ� ���̰�,(�α��� �������� ó��) 
		// loginId�� ���� ���ٸ� Ʋ�ȴٴ� �� (�α��� ���з� ó��)

		// ����ڰ� �α����� �ϰ� ���� �α׾ƿ� �Ǵ� �������� �ݱ� �������� �α����� �����ϰ� �־�� �Ѵ�. 
		// �Ϲ������� �α��� ����(���̵� ��) �� ����(session)�� ������ �ϵ��� ��. 
		// ������ ����(��Ĺ)���� �����ϴ� ������ �������. 
		// ���ǿ� �����͸� �����ϰ� �Ǹ� �������� �ݱ� �������� �������� ����Ǿ �����ʹ� ������. 
		
		if(loginId != null) {
			// �α��� ���� ó�� 
			// �α����� ȸ���� ���̵� ���ǿ� ���� 
			session.setAttribute("loginMember", loginId);
			mav.setViewName("membermain");
		} else {
			// �α��� ���� ó��
			mav.setViewName("memberlogin");
		}
				
		return mav;
	}

	public ModelAndView update() {
		mav = new ModelAndView();
		// �캯 : ���� �α����� �� ���¿��� ���� ��û�� �ϴ� ���̱� ������ 
		// 		 ���ǿ� ����� �α��� ���̵� ���� ������ ��. 
		//		 �����ͼ� loginId ������ ���� 
		String loginId = (String) session.getAttribute("loginMember");
		// ��������ȯ
//		double a=0.0;
//		int b=0;
//		b=(int) a;
		
		// update() �޼ҵ�� ���� �α����� ȸ���� ��ü ������ DB�� ���� �����ͼ�
		// memberupdate.jsp�� ����ϴ� ���� �����̱� ������ memberview �޼ҵ带 ����ص� ���� ����. 
//		MemberDTO memberUpdate = mdao.memberView(loginId);
		MemberDTO memberUpdate = mdao.update(loginId);
		
		mav.addObject("member123", memberUpdate);
		mav.setViewName("memberupdate");
		
		return mav;
	}

	public ModelAndView updateProcess(MemberDTO member) {
		mav = new ModelAndView();
		int updateResult = mdao.updateProcess(member);
		// ���� �Ϸ�: membermain.jsp
		// ���� ����: updatefail.jsp
		if(updateResult > 0) {
			mav.setViewName("membermain");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}

	public ModelAndView memberDelete(String mid) {
		mav = new ModelAndView();
		mdao.memberDelete(mid);
		// ������ ������ memberlist.jsp�� ��� 
		// memberlist.jsp�� ����� ������ �����ʹ� �ȶ�. 
		// memberlist.jsp�� ����� ��µǷ��� controller�� ���ļ� DB ��ȸ����� ������ memberlist.jsp�� �����ϴµ� 
		// �Ʒ��� ���� memberlist.jsp�� ����ϰ� �Ǹ� �����ʹ� ���������� ��. 
		
//		mav.setViewName("memberlist");
		// ���� ��Ʈ�ѷ��� �ּҸ� ��û�ؾ� ��.
		// ��Ʈ�ѷ��� �ּҸ� ��û�ϱ� ���� ��� 
		mav.setViewName("redirect:/memberlist");
		
		
		return mav;
	}

	public String idCheck(String mid) {
		String checkResult = mdao.idCheck(mid);
		/*
		 * checkResult�� ���� ��� �´ٸ� �ش� ���̵� DB�� �����Ѵٴ� ��.(���Ұ�) 
		 * checkResult�� ���� ���ٸ� �ش� ���̵� DB�� �������� �ʴ´ٴ� ��.(��밡��) 
		 */
		String result = "";
		if(checkResult == null) {
			result = "ok";
		} else {
			result = "no";
		}
		
		System.out.println("����Ŭ���� üũ���"+result);
		
		return result;
	}

	public MemberDTO memberViewAjax(String mid) {
		MemberDTO member = mdao.memberView(mid);
		return member;
	}

}








