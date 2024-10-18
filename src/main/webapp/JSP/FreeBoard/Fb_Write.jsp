<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/JSP/FreeBoard/IsLoggedIn.jsp"%>
<!--로그인 확인-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 / 글쓰기</title>
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
<script type="text/javascript">
function validateForm(form) {  
    if (form.title.value == "") {
        alert("제목을 입력하세요.");
        form.title.focus();
        return false;
    }
    if (form.content.value == "") {
        alert("내용을 입력하세요.");
        form.content.focus();
        return false;
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
				<div class="board_write">
					<form name="writeFrm" method="post" action="Fb_WriteProcess.free"
						onsubmit="return validateForm(this);">
						<fieldset>
							<legend>자유게시판 작성하기</legend>
							<h3 class="tit">자유게시판 작성하기</h3>
							<p class="note">
								<i class="star"></i>표시는 필수 입력 사항입니다.
							</p>
							<table>
								<caption class="nohead">자유게시판 작성하기 테이블</caption>
								<tr>
									<th>제목 <i class="star"></i></th>
									<td><input type="text" name="title"
										placeholder="제목을 입력해주세요" title="제목을 입력해주세요"></td>
								</tr>
								<tr>
									<th class="th_top">내용 <i class="star"></i></th>
									<td><textarea name="content" placeholder="게시물 내용을 작성해 주세요"
											title="게시물 내용을 작성해 주세요" rows="10"></textarea></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td class="td_flex">
										<div class="file_wrap">
											<input type="text" readonly> <label> <input
												type="file" class="blind"> 파일선택
											</label>
										</div>
										<p class="file_note">※ 등록 가능 확장자 :
											pdf,docx,pptx,xlsx,jpg,jpeg,gif,png / 최대 5MB</p>
									</td>
								</tr>
							</table>
							<div class="btn_wrap">
								<button type="submit" class="point_btn4">작성완료</button>
								<button type="button" class="point_btn5"
									onclick="location.href='Fb_List.free';">취소</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</section>
	</main>
	<jsp:include page='/JSP/Common/Footer.jsp' />
</body>
</html>