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
	
	
	public int memberJoin1(TestDTO member) {
		return sql.insert("tm.memberjoin", member);
	}

	public List<TestDTO> memberList() {
		return sql.selectList("tm.memberlist");
	}

	public TestDTO memberView(String tid) {
		return sql.selectOne("tm.memberview", tid);
	}

	public String memberLogin(TestDTO member) {
		return sql.selectOne("tm.memberlogin", member);
	}

	public TestDTO update(String loginId) {
		return sql.selectOne("tm.memberupdate", loginId);
	}

	public int updateProcess(TestDTO member) {
		return sql.update("tm.updateprocess", member);
	}

	public void memberDelete(String tid) {
		sql.delete("tm.memberdelete", tid);
	}

	public String idCheck(String tid) {
		return sql.selectOne("tm.idcheck", tid);
	}
	
	
}
