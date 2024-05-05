<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .container {
            width: 300px;
            margin: 100px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
        }
        input[type="text"], input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 3px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>로그인</h2>
<%--    <form action="/login_check.do" method="post">--%>
        <form:form modelAttribute="loginForm" id="loginForm" name="loginForm" action="/login_check.do" method="post">
        <input type="text" name="userid" placeholder="사용자 이름" required>
        <input type="password" name="passwd" placeholder="비밀번호" required>
        <input type="submit" value="로그인">
<%--        form으로 로그인 확인 처리 <h2>${form.id}님 안녕하세요 ^^</h2>--%>
            <c:choose>
            <c:when test="${loginch == true}">
            <h2>${sessionScope.id}님 안녕하세요 ^^</h2>
            </c:when>
                <c:otherwise>
                <h2>아이디와 비밀번호를 확인해주세요</h2>
                </c:otherwise>
            </c:choose>
        </form:form>
<%--    </form>--%>
</div>
</body>
<script>
    console.log("세션아이디?" + sessionScope.id);
</script>

</html>
