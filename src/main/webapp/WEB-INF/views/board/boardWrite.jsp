<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 글 작성</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board.css">
</head>
<body>
    <div class="container">
        <h1>게시판 글 작성</h1>
        <form:form modelAttribute="boardForm" id="boardForm" name="boardForm" action="/board/boardWrite.do" method="post">
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
                <input type="submit" value="작성" class="btn-create">
                 <a href="javascript:window.history.back();" class="btn-back">뒤로가기</a>
            </div>
        </form:form>
    </div>
</body>
</html>
