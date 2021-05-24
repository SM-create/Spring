package com.icia.study.controller;

import java.com.icia.study.service.StudyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudyController {
	
	
	@Autowired
	private StudyService ss;
	//서로 다른 컨트롤러에 있다고 하더라도 주소가 같은 메소드가 있으면 오류발생함.
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home() {
//		return "home";
//	}
	
	@RequestMapping(value="/insertpage")
	public String insertPage() {
		return "insert";
	}
	
//	@RequestMapping(value="/insert")
//	public void insertDB(@RequestParam("param1")String param1) {
//		System.out.println(param1);
//		ss.insertDB(param1);
//	}
//1011111111111111111
}
