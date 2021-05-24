package com.icia.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 컨트롤러 클래스로 지정하기 위한 어노테이션
@Controller
public class MainController {

	// 기본주소를 처리하기 위한 메소드 정의
	// @RequestMapping : 주소값을 받기 위한 이노테이션
//	@RequestMapping(value="/")
//	public void home() {
//		System.out.println("메소드 home 호출");
//	}
//	
	// 기본주소 요청이 왔을 때 home.jsp를 출력하기 위한 메소드
	@RequestMapping(value = "/")
	private String home1() {
		System.out.println("home1 메소드 호출");
		return "home"; // =>home.jsp를 출력하는 역할을함 servlet-context.xml 19~21번줄
	}

	// a 라는 주소 요청이 왔을 때 처리하기 위한 메소드 정의ㅌ
	// 메소드 이름은 homea, 메소드가 호출됐을 때 homea 메소드 호출이라고 sysout 출력
	@RequestMapping(value = "/a")
	public void homea() {
		System.out.println("homea 메소드 호출");
	}

	// /abc라는 주소요청이 왔을때 abc.jsp를 출력하는 메소드 정의
	// abc.jsp에서는 파란색으로 Hello World 출력

	@RequestMapping(value = "/abc")
	public String home2() {
		return "abc";
	}

	// form 태그를 통해 전송된 값을 처리할 메소드 정의
	@RequestMapping(value = "/paramtest")
	public void home3 (@RequestParam("param1") String aaa) {
		//RequestParam 어노테이션 : 화면(jsp)으로 부터 전송된 파라미터에 담긴 값을 꺼내는 역할
		//Param1에 담긴 값을 꺼내서 a 변수에 저장함.
		System.out.println("메소드 home3 호출");
		System.out.println(aaa);
	}
}
