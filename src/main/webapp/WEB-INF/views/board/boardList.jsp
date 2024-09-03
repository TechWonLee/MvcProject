<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/board.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/board.js"></script>
</head>
<body>
	<div class="container">
		<h1>게시판</h1>
		<a href="/board/boardWriteView.do?userid=${sessionId}"
			class="btn-create">글 작성</a>
			<a href="/board/excerciseBook.do?userid=${sessionId}"
			class="btn-create">연습장 페이지</a>
			
			<div id="chatModal" class="modal">
 			<button onclick="openChat()">Lets Chat</button>
</div>
			
		<div class="table-container">
		
		
			<table>
				<thead>
					<tr>
						<th style="text-align: center;">번호</th>
						<th style="text-align: center;">제목</th>
						<th style="text-align: center;">작성자</th>
						<th style="text-align: center;">작성일</th>
						<th style="text-align: center;">조회수</th>
						<th style="text-align: center;">글관리</th>
				
					</tr>
				</thead>
				<tbody>
					<c:forEach var="boardList" items="${boardList}">
						<tr>
							<td style="text-align: center;">${boardList.seq}</td>
							
							<td style="text-align: center;"><a
								href="/board/boardView.do?seq=${boardList.seq}">${boardList.title}</a></td>
							<td style="text-align: center;">${boardList.userid}</td>
							
							<td style="text-align: center;">${boardList.write_date}</td>
							<td style="text-align: center;">${boardList.view_cnt}</td>
							<td style="text-align: center;">
							<c:choose>
							<c:when test="${sessionId eq boardList.userid}">
									<a href="/board/boardView.do?seq=${boardList.seq}"
										class="btn-edit">수정</a>
									<a href="javascript:delete_board('${boardList.userid}','${boardList.seq}');" class="btn-delete">삭제</a>
								</c:when>
								<c:otherwise>
								<p>수정과 삭제는 작성자와 로그인 사용자가 동일할때, 가능합니다.</p>
								</c:otherwise>
								</c:choose>
								
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="javascript:window.history.back();" class="btn-back">뒤로가기</a>
	</div>
</body>
</html>
