<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<a href="joinpage1">회원가입페이지 </a><br><br>
	
	<a href="loginpage">로그인페이지 login</a><br><br>
	
		<a href="memberlist">회원목록출력 </a><br> 
		
	로그인아이디: ${sessionScope.loginMember} <br>
	
</body>
</html>
