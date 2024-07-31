<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/board.css">
<style>
.highlight {
	background-color: red; /* 클릭한 <td>의 배경을 빨간색으로 설정 */
}
</style>
</head>
<body>
	<div class="container">
		<h1>자바스크립트 연습장</h1>
		<table>
			<tr>
				<th colspan="3"><em>Bagua</em> Chart: Direction, Element,
					Color, Meaning</th>
			</tr>
			<tr>
				<td class="nw"><strong>Northwest</strong><br>Metal<br>Silver<br>Elders</td>
				<td class="n">...</td>
				<td class="ne">...</td>
			</tr>
			<tr>...2 more lines of this kind...
			</tr>
			<tr>...2 more lines of this kind...
			</tr>
		</table>
	</div>

	<div id="menu">
		<button data-action="save">저장하기</button>
		<button data-action="load">불러오기</button>
		<button data-action="search">검색하기</button>
	</div>
	<br>
	
	<div onclick="alert('div에 할당한 핸들러!(이벤트 버블링!!)')">
	<em><code>EM</code>을 클릭했는데도 <code>DIV</code>에 할당된 핸들러가 동작합니다.</em>
	</div> 
	<br>
	<div>
	<button data-sc="scvSir!" id="sc">scTest</button>
	</div>
	
<script src="${pageContext.request.contextPath}/js/excersice.js"></script>
</body>
</html>