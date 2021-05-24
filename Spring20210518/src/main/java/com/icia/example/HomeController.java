package com.icia.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.example.service.TestService;

@Controller
public class HomeController {

	/*
	 * service 클래스에 @Service 어노테이션을 붙인후 Controller 클래스에서 @Autowired를 붙여서 Service 클래스
	 * 객체를 선언하면 매번 new를 이용하여 객체를 만들지 않고도 Service 클래스의 자원 (필드,메소드)을 활용할 수 있움.
	 */

	// TestService에 있는 abc라는 메소드를 호출하고 싶다면
//	TestService tts = new TestService();
//	tts.abc();

	@Autowired 
	private TestService ts;

	@RequestMapping(value = "/")
	public String home1() {
		System.out.println("homeController첵스트");
		return "hello";
	}

	// 링크를 통해서 온 요청 처리하기
	@RequestMapping(value = "/test123")
	public void test123() {
		System.out.println("test123 주소요청");
	}

	// welcomejsp 주소이동
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "welcome";
	}

	// mag에 담겨운 데이터를 sysout으로출력 , method = 받는방식
	// method를 쓰지 않으면 get.post모두 받을 수 있음
	// 링크로 요청하는것은 get방식
	@RequestMapping(value = "/welcomemsg")
	public void welcommsg(@RequestParam("msg") String msg, @RequestParam("msg2") String msg2) {
		System.out.println(msg);
		System.out.println(msg2);
	}

//	링크로 넘어온 파라미터 받기
	@RequestMapping(value = "/linkmsg")
	public void linkmsg(@RequestParam("val1") String val1, @RequestParam("val2") String val2) {
		System.out.println(val1);
		System.out.println(val2);
	}

	// DB에 데이터 저장하기
	@RequestMapping(value = "/insertDB")
	public void insertDB(@RequestParam("data1") String data1) {
		System.out.println(data1);
	// 패키지 추가
	// com.icia.example.service
	// com.icia.example.dao
	// src/main/java/com/icia/example/이하에 dao,service 폴더가 같은 수준에 위치해야함
	
	//TestService클래스에 있는 method1을 호출
	
/*
 *  hello.jsp 에서 입력하고 저장 버튼 클릭
 *  HomeControler의 insertDB 메소드 호출되고
 *  여기서 TEstService의 method1 메소드 호출함.
 *  hello.jsp -> HomeController -> TestService -> DataBase
 */
	
	ts.method1();
	 //hello.jsp에서 넘어온 데이터를 TestService로 보내기
	 // 데이터를 넘겨서 method1에서 해당 데이터를 sysout로 출력해보세요
	ts.method2(data1);
	
	}

}
