<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    //jstl임포트..?
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update(){
		location.href='boardupdate?bnumber='+${board.bnumber};
	}
	
	function boardDelete(){
		var pwd= prompt('비밀번호를 입력하세요');
		var bpassword='$(board.bpassword)';
		if(pwd==bpassword){
			location.href='boarddelte?bnumber='+${board.bnumber};
		}else{
			alert('비밀번호 불일치');
		}
	}
	
</script>
</head>
<body>
	<h2>baordview.jsp</h2>
	
	글번호 : ${board.bnumber}<br>
	제목 :${board.btitle}<br>
	비밀번호:${board.bpassword}<br>
	작성자 : ${board.bwriter}<br>
	내용: ${board.bcontents}<br>
	작성일자: ${board.bdate}<br>
	조회수 : ${board. bhits}<br>
	<%-- 첨부파일 :${board.bfilename}<br> --%>
	<!--  이미지 : <img src="resources/upload/${board.bfilename}" height="200" width="200"><br>
	
	-->
	<a href="boardlist">목록으로 돌아가기</a>
	
	<!-- 수정 버튼을 클릭하면 boardupdate.jsp에 db가 저장된 데이터를 출력함
		제목,내용만  수정할 수 있도록함 글비밀번호 입력칸은 비우고 입력할 수 있도록
		수정할 내용과 비밀번호 입력후 수정을 클릭(비밀번호 일치하면 수정 처리 후 목록출력)
		비밀번호 일치하지 않으면 alert으로 비밀번호 불일치 출력
		수정처리 완료후 추가로 수정 내용이 반영된 글조회 화면을 출력-->
		
		<!--수정버튼 만들고 수정기능 구현-->
	<a href="boardupdate?bnumber=${board.bnumber}">수정</a>
	<button onclick="update()">수정버튼</button>
		<!--1.위의 수정링크를 클릭하면 controller-service-dao-db를 거쳐서 데이터를 가지고 boardupdate.jsp를 출력함
			2. 그리고 boardupdate.jsp에서 수정할 내용을 입력받고 db에  update쿼리를 수정해 줘야함-->
	
	<button onclick="boardDelete()">삭제</button><br>
	
	<a href="paging?page"=${page}">페이징 목록으로 돌아가기</a>
	
	<!-- 댓글 등록 부분 -->
	<div id="comment=write">
		작성자 :  <input type="text" id="ccontents"><br>
		내용 : <input type="text" id="ccontents"><br>
		<button id="cwrite-btn">댓글등록</button>
	</div>
	
	<!--댓글 목록 출력 부분-->
	<div id="comment=list">
		<table border="1">
			<tr>
			<th>작성자</th>
			<th>내용</th>
			</tr>
			<c:forEach var="comment" items="${commentList}">
				<tr>
					<td>${comment.cwriter}</td>
					<td>${comment.ccontents}</td>
				</tr>			
			</c:forEach>
		</table>
	</div>
	
	<!--   <script src="jquery코드복붙">     -->
	
	<script>
		$(document).ready(function(){
			
		$("#cwrite-btn").click(function(){
			var cwiter =document.getElementById('cwriter').value;
			var ccontents =document.getElementById('ccontents').value;
			var cbnumber ='${board.bnumber}';
			console.log(cwriter);
			console.log(ccontents);
			console.log(cbnumber);
			$.ajax({
				type: 'post',
				url:'comment/commentwrite',
				data:{
					'cwriter':cwriter,
					'ccontents':ccontents,
					'cbnumber':cbnumber,
					dataType: 'json',
					success: function(list){
						console.log(list);
						var output = "<table border='1'>";
						output += "<tr><th>작성자</th>";
						output += "<th>내용</th></tr>";
						for(var i in list){
							output += "<tr>";
							output += "<td>"+list[i].cwriter+"</td>";
							output += "<td>"+list[i].ccontents+"</td>";
							output += "</tr>";
						}
						output += "</table>";
						document.getElementById('comment-list').innerHTML = output;
						document.getElementById('cwriter').value='';
						document.getElementById('ccontents').value='';
					},
					error: function(){
						console.log('문제있음');
					}
				});
			});
		});
		});
	</script>
</body>
</html>