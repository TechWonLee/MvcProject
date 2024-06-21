<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div class="container">
    <h2>로그인</h2>
<%--    <form action="/login_check.do" method="post">--%>
        <form:form modelAttribute="loginForm" id="loginForm" name="loginForm" action="/login/login_check.do" method="post">
        <input type="text" name="userid" placeholder="유저 아이디" required>
        <input type="password" name="password" placeholder="비밀번호" required>
        <input type="submit" value="로그인">
<%--        form으로 로그인 확인 처리 <h2>${form.id}님 안녕하세요 ^^</h2>--%>
            <c:if test="${islogin == false}">
            <h2>아이디 또는 비밀번호를 확인해 주세요</h2>
            </c:if>
        </form:form>
<%--    </form>--%>
</div>
</body>

</html>
