<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/JSP/Announcement/IsLoggedIn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<link href="/resources/css/list.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
<script>
function deletePost() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.writeFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "An_DeleteProcess.an";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}

</script>
</head>
<body>
	<jsp:include page='/JSP/Common/Header.jsp' />

	<main id="container" class="sub_container list_page">
		<section class="sub_visual">
			<div class="inner">
				<div class="sub_wrap">
					<h3>공지사항</h3>
				</div>
			</div>
		</section>
		<section class="contents">
			<div class="inner">
				<div class="board_view">
					<div class="view_top">
						<c:if test="${UserId eq board.id }">
							<button type="button" onclick="deletePost()">삭제하기</button>
							<button type="button" class="modify_btn"
								onclick="location.href='An_Edit.an?num=${board.num}';">수정하기</button>
						</c:if>
						<!-- <a href="/JSP/Main/List_board_modify.jsp" class="modify_btn">글 수정하기</a> -->
					</div>
					<div class="view_tit">
						<h3>${board.title }</h3>
						<span class="date">${board.postdate }</span>
					</div>
					<div class="view_con">
						<c:if test="${empty board.content }">내용없음</c:if>
						<c:if test="${not empty board.content }">${board.content }</c:if>
					</div>
					<dl class="view_paging">
						<dt>이전글</dt>
						<dd>
							<c:if test="${not empty board.prevNum}">
								<a href="An_View.an?num=${board.prevNum}">${board.prevTitle}</a>
							</c:if>
							<c:if test="${empty board.prevNum}">
								<span>이전글이 없습니다</span>
							</c:if>
						</dd>
					</dl>

					<dl class="view_paging">
						<dt>다음글</dt>
						<dd>
							<c:if test="${not empty board.nextNum}">
								<a href="An_View.an?num=${board.num}">${board.nextTitle}</a>
							</c:if>
							<c:if test="${empty board.nextNum}">
								<span>다음글이 없습니다</span>
							</c:if>
						</dd>
					</dl>
					<div class="btn_wrap">
						<button type="button" class="point_btn3"
							onclick="location.href='An_List.an';">목록</button>
						<!-- <a class="point_btn3" href="/JSP/Main/list_board.jsp">목록</a> -->
					</div>
				</div>
			</div>
		</section>
	</main>

	<h2>View</h2>
	<form name="writeFrm">
		<input type="hidden" name="num" value="${board.num }" />
		<!-- 공통 링크 -->

		<table border="1" width="90%" style="border-collapse: collapse">
			<tr>
				<td align="center">작성자</td>
				<td>${board.name }</td>
				<td align="center">작성일</td>
				<td>${board.postdate }</td>
			</tr>
			<tr>
				<td align="center">제목</td>
				<td colspan="3">${board.title }</td>
			</tr>
			<tr>
				<td align="center">내용</td>
				<td colspan="3" height="100px"><c:if
						test="${empty board.content }">내용없음</c:if> <c:if
						test="${not empty board.content }">${board.content }</c:if></td>
			</tr>
			<tr>
				<td colspan="4" align="right"><c:if
						test="${UserId eq board.id }">
						<button type="button"
							onclick="location.href='An_Edit.an?num=${board.num}';">수정하기</button>
						<button type="button" onclick="deletePost()">삭제하기</button>
					</c:if>
					<button type="button" onclick="location.href='An_List.an';">
						목록 보기</button></td>
			</tr>
		</table>
	</form>
	<table border="1" style="width: 100%;">
		<tr>
			<td>댓글 작성자 : ${board.id }</td>
			<td rowspan="2">
				<button id="btnSave" type="button">확인</button>
			</td>
		</tr>
		<tr>
			<td><textarea rows="5" cols="80" placeholder="내용을 입력하세요"
					id="content"></textarea></td>
		</tr>
	</table>

	<jsp:include page='/JSP/Common/Footer.jsp' />
</body>
</html>
