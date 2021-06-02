package com.icia.test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.icia.test.dto.TestDTO;

@Repository

public class TestDAO {
	
	@Autowired
	
	private SqlSessionTemplate sql;
	
	
	//join
	public int memberJoin(TestDTO member) {
		//namespace=tm
		return sql.insert("tm.memberjoin", member);
	}
	
	public List<TestDTO> memberList(){
		return sql.selectList("tm.memberList");
	}
	
	
	public TestDTO memberView(String tid) {
		return sql.selectOne("tm.memberview", tid);
	}
	
	//idCheck
	public String idCheck(String tid) {
		return sql.selectOne("tm.idcheck", tid);
	}

}
