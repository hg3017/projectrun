<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script>
alter(${pageContext.request.contextPath});
</script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/swiper-bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

  <!-- css 파일 연결 -->
  <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/sub.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
<style>
</style>
</head>
<body>
    <jsp:include page= '../Common/Header.jsp' />
    <h1 style="font-size:24px">공지사항</h1>
	<!-- 검색 -->
	<form method="get">
		<table width="50%" style="border-collapse: collapse">
			<tr>
				<td align="right"><select name="searchField">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="searchWord" /> <input type="submit"
					value="검색" /></td>
			</tr>
		</table>
	</form>
	<!-- 공지사항 목록 -->
	<table border="1" width="50%" style="border-collapse: collapse">
		<!-- 각각의 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
	<c:if test="${empty boards}">
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr> 
	</c:if>
	
		<c:forEach var="board" items="${boards }" varStatus="status">
		<tr align="center">
			<td>${boards.size() - status.index}</td>
			<!--게시물 번호-->
			<td align="left">
				<!--제목(+ 하이퍼링크)--> <a href="View.an?num=${board.num }">${board.title }</a>
			</td>
			<td align="center">${board.id }</td>
			<!--작성자 아이디-->
			<td align="center">${board.visitcount }</td>
			<!--조회수-->
			<td align="center">${board.postdate }</td>
			<!--작성일--> 
		</tr>
		</c:forEach>
	</table>
	<table width="50%" style="border-collapse: collapse">
		<tr align="right">
			<td>
			<c:if test="${UserId eq 'hong01' }">
				<button type="button" onclick="location.href='Write.an';">글쓰기</button>
			</c:if>
			</td>
		</tr>
	</table>
	   
	<jsp:include page= '../Common/Footer.jsp' />   
	   
</body>
</html>