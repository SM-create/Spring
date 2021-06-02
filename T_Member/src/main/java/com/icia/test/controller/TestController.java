package com.icia.test.controller;

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

	// ȸ������
	@RequestMapping(value = "/joinpage")
	public String joinpage() {
		return "memberjoin";
	}

	/*
	 * @RequestMapping(value="/memberjoin") public ModelAndView
	 * T_memberjoin(@RequestParam("tid") String tid,
	 * 
	 * @RequestParam("tpassword") String password,
	 * 
	 * @RequestParam("tname") String tname,
	 * 
	 * @RequestParam("tpnumber") int tpnumber,
	 * 
	 * �����ʻ��� �߰�
	 * 
	 * @RequestParam("temail") String teamail) { T_memberDTOmember = new
	 * T_memberDTO(); member.setTid(tid); member.setTpassword(tpassword);
	 * member.setTname(tname); member.setTpnumber(tpnumber);
	 * member.setTeamail(teamil);
	 * 
	 * mav = ts.T_member }
	 * 
	 * 
	 */

	@RequestMapping(value = "/memberjoin")
	public ModelAndView memberjoin(@ModelAttribute TestDTO member) {
		mav = ts.memberJoin(member);

		// ȸ������ �Ϸ�� �α��� ������ ���
		return mav;
	}

	@RequestMapping(value = "/memberlist")
	public ModelAndView memberList() {
		mav = ts.memberList();

		return mav;
	}

	@RequestMapping(value = "/memberview")
	public ModelAndView memberview(@RequestParam("tid") String tid) {

		mav = ts.memberView(tid);

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
