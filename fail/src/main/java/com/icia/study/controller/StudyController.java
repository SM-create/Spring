package com.icia.member.controller;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private HttpSession session;
	
	// home.jsp���� joinpage ��ũŬ�� ��û�� �ϸ� 
	// �Ʒ� �޼ҵ尡 ȣ��� 
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
//		// ȸ�������� �Ϸ�Ǹ� �α��� �������� ��µǵ��� 
//		return mav;
//	}
	
	@RequestMapping(value="/memberjoin")
	public ModelAndView memberJoin(@ModelAttribute MemberDTO member) {
		mav = ms.memberJoin(member);

		// ȸ�������� �Ϸ�Ǹ� �α��� �������� ��µǵ��� 
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
	
	// �α��� ȭ�� ��� �޼ҵ�
	@RequestMapping(value="/loginpage")
	public String loginPage() {
		return "memberlogin";
	}
	
	// �α��� ó�� �޼ҵ� 
	@RequestMapping(value="/login")
	public ModelAndView memberLogin(@ModelAttribute MemberDTO member) {
		// member ��ü���� memberlogin.jsp ���� �Է��� mid, mpassword ���� �������. 
		System.out.println("login �޼ҵ�"+member.toString());
		mav = ms.memberLogin(member);
		return mav;
	}
	
	// �α׾ƿ� ó�� �޼ҵ� 
	@RequestMapping(value="/logout")
	public String logout() {
		// �α׾ƿ��� ���ǿ� ����� ������ ����ٴ� ���� 
		session.invalidate();
		return "home";
	}
	
	// ȸ������ ���� ��û �޼ҵ� 
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		
		return mav;
	}
	
	// ȸ������ ���� ó�� �޼ҵ� 
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO member) {
		mav = ms.updateProcess(member);
		return mav;
	}
	
	// ȸ������ ó�� �޼ҵ�
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav = ms.memberDelete(mid);
		return mav;
	}
	
	// ���̵� �ߺ�Ȯ�� �޼ҵ� 
	@RequestMapping(value="/idcheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		System.out.println("idCheck �޼ҵ� ȣ���");
		System.out.println("�Է� id�� "+mid);
		String result = ms.idCheck(mid);
		
		return result;
	}
	
	// ajax�� ����ȸ 
	@RequestMapping(value="/memberviewajax")
	public @ResponseBody MemberDTO memberViewAjax(
							@RequestParam("mid") String mid) {
		System.out.println("memberViewAjax �޼ҵ� ȣ���");
		System.out.println("���� id�� "+mid);
		MemberDTO member = ms.memberViewAjax(mid);
		System.out.println(member);
		return member;
	}
	
	
}
