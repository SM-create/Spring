<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style>
h2 {
	background-color: yellow;
	color: red;
}
</style>

</head>
<body>
	<h2>hello.jsp</h2>
	<h2>안녕하세요</h2>
	<a href="https://www.google.com">구글</a>
	<a href="test123">test123</a>

	<!--  -->
	<a href="welcome">welcom.jsp로 이동</a>

	<h2>DB에 데이터 저장하기</h2>
	
	<form action="insertDB" method="get">
	입력 1: <input type="text" name="data1" ><br>
	<input type="submit" value="저장">	
	</form>
</body>
</html>