<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table,tr,th,td{
		border : 1px solid black;
		border-collapse: collapse;
	}
	
</style>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>
	<h2>boardlist.jsp</h2>
	
	<%-- 글제목 : ${result.btitle}<br>
	비밀번호 : ${result.bpassword}<br>
	작성자 : ${result.bwiter}<br>
	내용 : ${result.bcontents}<br> --%>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>

	<c:forEach var="board" items="${boardlist}">
		<tr>
			<td>${board.bnumber }</td>
			<td>${board.bwiter}</td>
			<td><a href="boardview?bnumber=${board.bnumber}">${board.btitle}</a></td>
			<td>${board.bdate}</td>
			<td>${board.bhits}</td>
		</tr>

	</c:forEach>

	</table>
	
	<a href="writepage">글쓰기화면</a>
	
</body>

</html>