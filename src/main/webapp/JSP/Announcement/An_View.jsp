<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/JSP/Announcement/IsLoggedIn.jsp"%>

<script>
function deletePost() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.writeFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "/An_DeleteProcess.an";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}
</script>

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
				<form name="writeFrm" method="post">
					<input type="hidden" name="idx" value="${board.idx}" />
				</form>
				<div class="view_top">
					<c:if test="${UserId eq board.member_id }">
						<a href="#"
							onclick="location.href='An_Edit.an?idx=${board.idx}'; return false;">수정하기</a>
						<a href="#" onclick="deletePost(${board.idx}); return false;">삭제하기</a>
					</c:if>
				</div>
				<div class="view_tit">
					<h3>${board.title }</h3>
					<span class="date">${board.regidate }</span>
				</div>
				<div class="view_con">
					<c:if test="${empty board.content }">내용없음</c:if>
					<c:if test="${not empty board.content }">${board.content }</c:if>
				</div>
				<!-- 파일 첨부 정보 -->
				<div class="view_file" align="right">
					<h3>첨부파일</h3>
					<c:if test="${not empty board.ofile}">
						<a href="/FileDown.an?sFile=${board.sfile}&oFile=${board.ofile}">${board.ofile}</a>
					</c:if>
					<c:if test="${empty board.ofile}">
						<span>첨부파일 없음</span>
					</c:if>
				</div>
				<br>

				<dl class="view_paging">
					<dt>이전글</dt>
					<dd>
						<c:if test="${not empty board.prevNum}">
							<a href="An_View.an?idx=${board.prevNum}">${board.prevTitle}</a>
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
							<a href="An_View.an?idx=${board.nextNum}">${board.nextTitle}</a>
						</c:if>
						<c:if test="${empty board.nextNum}">
							<span>다음글이 없습니다</span>
						</c:if>
					</dd>
				</dl>
				<div class="btn_wrap">
					<button type="button" class="point_btn3"
						onclick="location.href='/An_List.an';">목록</button>
				</div>
			</div>
		</div>
	</section>
</main>

<%-- 	<table border="1" style="width: 100%;">
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
	</table> --%>

