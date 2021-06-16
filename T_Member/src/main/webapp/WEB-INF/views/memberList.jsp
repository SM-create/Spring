<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td, th {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h2>memberlist.jsp</h2>
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
				<!-- http://localhost:8081/member/memberview?mid=aa
						memberview 라는 주소를 요청하면서 mid 파라미터에 aa를 담아서 간다  -->
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>