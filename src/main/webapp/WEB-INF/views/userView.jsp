<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<h1>회원 정보</h1>
<div class="container">
    <div class="user-info">
        <div>
            <label>아이디:</label> ${userInfo.userid}
        </div>
        <div>
            <label>비밀번호:</label> ${userInfo.passwd}
        </div>
        <div>
            <label>이름:</label> ${userInfo.name}
        </div>
        <div>
            <label>이메일:</label> ${userInfo.email}
        </div>
        <div>
            <label>가입일:</label> ${userInfo.join_date}
        </div>
    </div>
    <a href="javascript:window.history.back();" class="btn-back">뒤로 가기</a>
</div>
</body>
</html>
