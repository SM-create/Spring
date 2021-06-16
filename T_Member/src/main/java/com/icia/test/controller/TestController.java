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

	// ȸ������
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
	 * �����ʻ��� �߰�
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

		// ȸ������ �Ϸ�� �α��� ������ ���
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

	// �α��� ó�� �޼ҵ�
	@RequestMapping(value = "/login")
	public ModelAndView memberLogin(@ModelAttribute TestDTO member) {
		System.out.println("login �޼ҵ�" + member.toString());
		mav = ts.memberLogin(member);
		return mav;
	}

	// �α��� ȭ�� ��� �޼ҵ�
	@RequestMapping(value = "/loginpage")
	public String loginPage() {
		return "memberlogin1";
	}


	// �α׾ƿ� ó�� �޼ҵ�
	@RequestMapping(value = "/logout")
	public String logout() {
		// �α׾ƿ��� ���ǿ� ����� ������ ����ٴ� ����
		session.invalidate();
		return "home";
	}

	// ȸ������ ���� ó�� �޼ҵ� 
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute TestDTO member) {
		mav = ts.updateProcess(member);
		return mav;
	}
	
	// ȸ������ ���� ��û �޼ҵ� 
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ts.update();
		
		return mav;
	}

	// ���̵� �ߺ�Ȯ��
	@RequestMapping(value = "/idcheck")
	public @ResponseBody String idCheck(@RequestParam("tid") String tid) {
		System.out.println("idCheck �޼ҵ� ȣ���");
		System.out.println("�Է� id��" + tid);
		String result = ts.idCheck(tid);

		return result;
	}

	// ajax�� ����ȸ
	@RequestMapping(value = "/memberviewajax")
	public @ResponseBody TestDTO memberViewAjax(@RequestParam("tid") String tid) {
		System.out.println("memberViewAjax �޼ҵ� ȣ���");
		System.out.println("���� id�� " + tid);

		TestDTO member = ts.memberViewAjax(tid);

		System.out.println(member);

		return member;
	}

}
