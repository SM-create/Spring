package com.icia.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.example.dao.TestDAO;

@Service
public class TestService {

	
	@Autowired
	private TestDAO tdao; //TestDAO import시 사용가능
	
	public void method1() {
		System.out.println("method1 호출됨.");
	}
	
	public void method2(String data1) {
		System.out.println(data1);
		//hello.jsp -> HomeController에서 받은 data1을 TestDAO 클래스의 daoMethod1()으로 전달
		tdao.daoMethod1(data1);
	}
	
}
