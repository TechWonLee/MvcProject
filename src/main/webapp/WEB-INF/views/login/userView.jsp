<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>유저 정보</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<h1>유저 정보</h1>
<div class="container">
    <div class="user-info">
        <div>
            <label>아이디:</label> ${userinfo.userid}
            <input type="hidden" name="userid" value="${userinfo.userid}">
        </div>
        <div>
            <input type="hidden" name="password" value="${userinfo.password}">
        </div>
        <div>
            <label>이름:</label> ${userinfo.name}
        </div>
        <div>
            <label>이메일:</label> ${userinfo.email}
        </div>
        <div>
            <label>가입일:</label> ${userinfo.join_date}
        </div>
    </div>
    <div class="button-container">
    <a href="/board/boardList.do?userid=${userinfo.userid}&password=${userinfo.password}" class="btn-board">게시판</a>
    
    <a href="javascript:window.history.back();" class="btn-back">뒤로 가기</a>
</div>
    
</div>
</body>
</html>
