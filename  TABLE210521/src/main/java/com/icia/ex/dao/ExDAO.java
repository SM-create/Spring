package com.icia.ex.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icia.ex.dto.ExDTO;

@Repository

public class ExDAO {
	
	//DAO : data access object
	//DTO : data Transfer object
	public void insert (ExDTO dto) {
		
		
//		sql.insert("ex.insertDB",dto);
//		
	}

	public List<ExDTO> select() {
		
		return sql.selectList("ex.selectDB");
	}
	
		
	}


