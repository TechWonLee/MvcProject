<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 30px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .user-info {
            margin-top: 20px;
        }

        .user-info div {
            margin-bottom: 10px;
        }

        .user-info label {
            font-weight: bold;
        }

        .btn-back {
            display: block;
            width: 120px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .btn-back:hover {
            background-color: #45a049;
        }
    </style>
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
