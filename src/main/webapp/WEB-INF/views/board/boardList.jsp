<%@ page  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board.css">
</head>
<body>
    <div class="container">
        <h1>게시판</h1>
        <a href="/board/boardWriteView.do?userid=${userinfo.userid}" class="btn-create">글 작성</a>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="boardList" items="${boardList}">
                        <tr>
                            <td>${boardList.seq}</td>
                            <td><a href="${pageContext.request.contextPath}/viewPost?id=${boardList.userid}">${boardList.title}</a></td>
                            <td>${boardList.userid}</td>
                            <td>${boardList.write_date}</td>
                            <td>${boardList.view_cnt}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/editPost?id=${boardList.userid}" class="btn-edit">수정</a>
                                <a href="${pageContext.request.contextPath}/deletePost?id=${boardList.userid}" class="btn-delete">삭제</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a href="javascript:window.history.back();" class="btn-back">뒤로가기</a>
    </div>
</body>
</html>
