package java.com.icia.study.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	
	public void insertDB(String param1) {
		sql.insert("study.insertDB", param1);
	}


}
