<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>유저 아이디 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<h1>유저 아이디 목록</h1>
<ul>
    <c:forEach var="userlist" items="${userList}">
        <li><a href="/login/view/${userlist.userid}">${userlist.userid}</a></li>
    </c:forEach>
</ul>
</body>
</html>
