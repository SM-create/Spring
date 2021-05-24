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
	<a href="insertpage">insert.jsp로 이동</a>
	<!-- 아래링크 클릭 =>controller 요청 =>studyService =>studyDAO=>mapper에서 끝이 아니라=>mapper =>studyDAO=>studycontroller=>select.jsp -->
	<a href="select">DB</a>
</body>
</html>
