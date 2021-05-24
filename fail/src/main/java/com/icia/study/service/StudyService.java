package com.icia.study.service;

import org.springframework.stereotype.Service;

@Service
public class StudyService {

//	@Autowired
//	private StudyDAO sdao;
//	
//	private modelAndview mav;
//	
//	public void insertDB(String param1) {
//		sdao.insertDB(param1);
//	}
//	
//	public ModelAndView selectDB(){
//		mav= new ModelAndView();
//		//DB에서 조회한 내용을 ArrayList에 저장
//		//우변: db에서 조회한 결과를 List 에 담아옴
//		//죄변: 담아온 내용을 dbList 변수에 저장
//		//select*from 쿼리를 실행하면 결과는 list로 담는다.
//		List<String> dbList =sdao.selectDB();
//		//dbList에 담긴 값을 가지고 select.jsp로 이동해야함.
//		// 어떤 데이터를 어떤 페이지로 가지고 가기 위해 mav객체 이용
//		
//		//DBlist 변수값 확인
//		system.out.println("dbList확인");
//		for(int i=0; i=dbList.size(); i++) {
//			system.out.println(dbList.get(i));
//		}
//		
//		//데이터를 담기
//		mav.addObject("dbList1", dbList);
//		//목적지를 지정하는 내용(JSP 파일 이름)
//		mav.setViewName("select");
//		
//		//그냥 화면으로만 갈때는 컨트롤러에서 string 리턴만 하면 되지만 
//		// 어떤 데이터를 가지고 갈때는 mav 이용
//		
//		//return null;
//		return mav;
//	}

}
