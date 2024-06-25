<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board.css">
</head>

<body>
    <div class="container">
        <h1>게시글 상세보기</h1><br>
        <div class="detail-group">
            <label for="author" style="text-align: center;">작성자: ${board.userid} </label>
            
        </div>
        <div class="detail-group">
            <label for="title">제목</label>
            <p id="title" style="text-align: center;">${board.title}</p>
        </div>
        <div class="detail-group">
            <label for="content">내용</label>
            <p id="content" style="text-align: center;" >${board.content}</p>
        </div>
        <div class="detail-buttons">
            <a href="${pageContext.request.contextPath}/board/boardEdit.do?boardId=${board.userid}" class="btn-edit">수정</a>
            <a href="javascript:window.history.back();" class="btn-back">뒤로가기</a>
        </div>
    </div>
</body>
</html>