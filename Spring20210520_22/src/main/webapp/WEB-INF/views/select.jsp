<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- jstl :jsp에서 제공하는 문법으로 if, for등과 같은 제어문 문법을 사용할 수 있도록함. -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>insert title here</title>
</head>
<body>
<h1>
	select.jsp
</h1>
<!-- jstl에서 제공하는 반복문 문법을 활용하여 dbList담긴 내용 출력 -->

	<c:forEach var="test123" items="$(dbList1)">
	
	<!-- var속성 : 현위치에서 사용할 변수이름
		items 속성 : mav에 담을 때 지정한 이름 -->
	$(test123)<br>
	</c:forEach>
</body>
</html>
