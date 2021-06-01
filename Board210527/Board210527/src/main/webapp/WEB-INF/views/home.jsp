<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	
<<<<<<< HEAD
	<a href="writepage">글쓰기화면</a><br>
	<!-- 	<a href="boardwrite">글쓰기화면</a><br> -->
	<!-- 목록 링크를 클릭하면 단순히 boardlist.jsp로 이동하는 것이 아니라
		DB에서 데이터를 가져와서 boardlist.jsp에 출력	-->
	<a href="boardlist">글목록</a><br>
	
	<a href="paging">페이징처리목록</a><br>
=======
	<a href="witepage">boardwrite.jsp 이동 글쓰기 화면</a><br>
	<a href="boardwrite">글쓰기 화면</a><br>
	<a href="boardlist">boardlist.jsp 이동 글목록</a><br>
	
>>>>>>> branch 'master' of https://github.com/SM-create/Spring.git
	
</body>
</html>
