<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/JSP/FreeBoard/IsLoggedIn.jsp"%>

<% String typeParam = "FreeBoard"; %>

<script>
function deletePost() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.writeFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "/Fb_DeleteProcess.free";  // 전송 경로
        form.submit();                      // 폼값 전송
    }
}

</script>

<main id="container" class="sub_container list_page" style="background: #fff;">
	<section class="sub_visual">
		<div class="inner">
			<div class="sub_wrap">
				<h3>자유게시판</h3>
			</div>
		</div>
	</section>
	<section class="contents" >
		<div class="inner">
			<div class="board_view">
			<div class="bWrite" style="padding-bottom: 80px;">
			
				<form name="writeFrm" method="post">
					<input type="hidden" name="idx" value="${board.idx}" />
				</form>
				<div class="view_top">
					<c:if test="${UserId eq board.member_id }">
						<a href="#"
							onclick="location.href='Fb_Edit.free?idx=${board.idx}'; return false;">수정하기</a>
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
							<a href="Fb_View.free?idx=${board.prevNum }">${board.prevTitle }</a>
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
							<a href="Fb_View.free?idx=${board.nextNum}">${board.nextTitle}</a>
						</c:if>
						<c:if test="${empty board.nextNum}">
							<span>다음글이 없습니다</span>
						</c:if>
					</dd>
				</dl>
			</div>
				
				<jsp:include page="/JSP/Common/Comment.jsp" flush="true">
		<jsp:param value="FreeBoard" name="boardType"/>
		<jsp:param value= "${ board.idx }" name="boardIdx"/>
	</jsp:include> 
				
				<div class="btn_wrap">
					<button type="button" class="point_btn3"
						onclick="location.href='/Fb_List.free';">목록</button>
				</div>
			</div>
		</div>
	</section>
</main>
