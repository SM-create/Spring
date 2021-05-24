package com.icia.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class StudyController {
	
	@Autowired
	
	//서로 다른 컨트롤러에 있다고 하더라도 주소가 같은 메소드에 있으면 오류 발생함.
	//주소로 사용하는 (value="") 값은 중복X
	
//	@RequestMapping(value="/") //, method = RequestMethod.GET
//	public String home() {
//		return "home";
//	}

	@RequestMapping(value="/insertpage")
	public @ResponseBody String insertpage() {
		return "insert";
	}
	
	@RequestMapping(value="/insert")
	public void insertDB(@RequestParam("param1") String param1) {
		System.out.println(param1);
		ss.insertDB(param1);
	}
	
}
