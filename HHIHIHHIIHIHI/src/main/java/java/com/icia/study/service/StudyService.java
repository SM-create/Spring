package java.com.icia.study.service;

import java.com.icia.study.dao.StudyDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

	@Autowired
	private StudyDAO sdao;
	
	public void insertDB(String param1) {
		sdao.insertDB(param1);
	}
}
