<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>memberview.jsp</h2>
	아이디 : ${result.tid} <br>
	비밀번호 : ${result.tpassword} <br>
	이름 : ${result.tname} <br>
	전화번호 : ${result.tpnumber} <br>
	이메일 : ${result.temail} <br>
	
	<a href="./">홈으로</a>
	<a href="memberlist">리스트로 돌아가기</a>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.tid}</td>
				<td>${member.tpassword}</td>
				<td>${member.tname}</td>
				<td>${member.tpnumber}</td>
				<td>${member.temail}</td>
				<!-- 조회 링크를 클릭하면 memberview.jsp에 해당 회원의 정보만 출력 -->
				<td><a href="memberview?tid=${member.tid}">조회</a></td>

				<!-- http://localhost:8081/member/memberview?tid=aa -->
			</tr>
		</c:forEach>
		
		</table>
		
</body>
</html>