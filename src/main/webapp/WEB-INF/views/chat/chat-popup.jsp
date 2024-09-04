<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lets Chat</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/chat.js"></script>
</head>
<body>
    <div>
        <button id="openSocketBtn" type="button">대화방 참여</button>
        <button id="closeSocketBtn" type="button">대화방 나가기</button>
        <br/><br/><br/>
        메세지 입력:
        <input type="text" id="sender" value="${sessionId}" style="display: none;">
        <input type="text" id="messageinput">
        <button id="sendMessageBtn" type="button">메세지 전송</button>
        <button id="clearTextBtn" type="button">대화내용 지우기</button>
    </div>
    <div id="messages"></div>
</body>
</html>
