<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/board.js"></script>
</head>
<body>
    <div class="container">
        <h1>게시판 글 작성</h1>
        <form:form modelAttribute="boardForm" id="boardForm" name="boardForm" action="/board/boardWrite.do" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="userid">작성자: ${userinfo.userid}</label>
                <input type="hidden" id="userid" name="userid" value="${userinfo.userid}">
                <input type="hidden" id="name" name="name" value="${userinfo.name}">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="content" rows="10" required></textarea>
            </div>
            
            <div class="form-group">
                <h2>파일 업로드</h2>
                <button id="btn-upload" type="button" style="border: 1px solid #ddd; outline: none;">파일 추가</button>
                <input id="input_file" multiple="multiple" type="file" style="display: none;">
                <span style="font-size: 10px; color: gray;">※첨부파일은 최대 10개까지 등록이 가능합니다.</span>
                <div class="data_file_txt" id="data_file_txt" style="margin: 20px 0;">
                    <span>첨부 파일</span><br>
                    <div id="articlefileChange"></div>
                </div>
            </div>
            <div class="form-group">
                <input type="submit" value="작성" class="btn-create">
                <a href="javascript:window.history.back();" class="btn-back">뒤로가기</a>
            </div>
        </form:form>
    </div>
</body>
</html>
