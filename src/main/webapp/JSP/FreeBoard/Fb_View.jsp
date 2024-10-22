<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/JSP/FreeBoard/IsLoggedIn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 / 상세보기</title>
<link rel="icon" href="/resources/images/common/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="images/common/free-icon-running-7126743.png">

<!-- js 파일 연결 -->
<!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
<script src="/resources/js/jquery-3.7.1.min.js"></script>
<script src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/swiper-bundle.min.js"></script>
<script src="/resources/js/aos.js"></script>
<script src="/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

<!-- css 파일 연결 -->
<link href="/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link
	href="/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/sub.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/main.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/common.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/list.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<script>
function deletePost() {
    var confirmed = confirm("정말로 삭제하겠습니까?"); 
    if (confirmed) {
        var form = document.writeFrm;       // 이름(name)이 "writeFrm"인 폼 선택
        form.method = "post";               // 전송 방식 
        form.action = "Fb_DeleteProcess.free";  // 전송 경로
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
					<h3>자유게시판</h3>
				</div>
			</div>
		</section>
		<section class="contents">
			<div class="inner">
				<div class="board_view">
					<div class="view_top">
						<c:if test="${UserId eq board.id }">
							<button type="button" class="modify_btn"
								onclick="location.href='Fb_Edit.free?num=${board.num}';">수정하기</button>
							<button type="button" onclick="deletePost()">삭제하기</button>
						</c:if>
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
								<a href="An_View.an?num=${board.nextNum}">${board.nextTitle}</a>
							</c:if>
							<c:if test="${empty board.nextNum}">
								<span>다음글이 없습니다</span>
							</c:if>
						</dd>
					</dl>
					<div class="btn_wrap">
						<button type="button" class="point_btn3"
							onclick="location.href='Fb_List.free';">목록</button>
					</div>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page='/JSP/Common/Footer.jsp' />
</body>
</html>
