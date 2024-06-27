<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<title>게시글 상세보기</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/board.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/board.js"></script>

</head>

<body>
	<div class="container">
		<h1>게시글 상세보기</h1>
		<br>
		<div class="detail-group">
			<label for="author" style="text-align: center;">작성자:
				${board.userid} </label> <input type="hidden" id="userid"
				value="${board.userid}"> <input type="hidden" id="seq"
				value="${board.seq}">

		</div>
		<div class="detail-group">
			<label for="title">제목</label>
			<p id="BoardTitle" style="text-align: center;">${board.title}</p>
			<input type="hidden" id="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<p id="showcontent" style="text-align: center;">${board.content}</p>
			<input type="hidden" id="boardContent" value="${board.content}">
			<div id="content-div"></div>
		</div>

		<div id="detail-buttons" class="detail-buttons">
			<c:if test="${sessionId eq board.userid}">
				<button id="editbutton" class="btn-edit">수정</button>
			</c:if>
			<a href="javascript:window.history.back();" class="btn-back">뒤로가기</a>

		</div>
	</div>
</body>
</html>