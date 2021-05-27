<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>
	<h2>boardlist.jsp</h2>
	
	글제목 : ${result.btitle}<br>
	비밀번호 : ${result.bpassword}<br>
	작성자 : ${result.bwiter}<br>
	내용 : ${result.bcontents}<br>
	
	<table>
		<tr>
			
			<th>글제목</th>
			<th>비밀번호</th>
			<th>작성자</th>
			<th>내용</th>
		
			
		</tr>

	<c:forEach var="board" items="$(boardlist)">
		<tr>
			<td>${board.btitle }</td>
			<td>${board.bpassword }</td>
			<td>${board.bwiter}</td>
			<td>${board.bcontenst}</td>
			
		</tr>

	</c:forEach>

	</table>
</body>
</html>