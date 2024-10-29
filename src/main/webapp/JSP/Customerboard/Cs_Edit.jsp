<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function validateForm(form) { // 폼 내용 검증 
		if (form.category.value == "") {
			alert("분류를 선택하세요.");
			form.category.focus();
			return false;
		}
		if (form.ableview.value == "") {
			alert("공개여부를 선택하세요.");
			form.ableview.focus();
			return false;
		}
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

<main id="container" class="sub_container list_page">
	<section class="sub_visual">
		<div class="inner">
			<div class="sub_wrap">
				<h3>Q&A</h3>
			</div>
		</div>
	</section>
	<section class="contents">
		<div class="inner">
			<div class="board_write">
				<form name="editFrm" method="post" action="Cs_EditProcess.co"
					onsubmit="return validateForm(this);">
					<input type="hidden" name="idx" value="${board.idx}" />
					<fieldset>
						<legend>게시물 수정하기</legend>
						<h3 class="tit">Q&A 수정하기</h3>
						<p class="note">
							<i class="star"></i>표시는 필수 입력 사항입니다.
						</p>
						<c:if test="${not empty board}">
							<table>
								<caption class="nohead">게시물 수정하기 테이블</caption>
								<tr>
									<th>분류 <i class="star"></i></th>
									<td>
										<label class="radio">
											<input type="radio" name="category" value="모임개설하기">모임개설하기
										</label>
										<label class="radio">
											<input type="radio" name="category" value="모임참가하기">모임참가하기
										</label>
										<label class="radio">
											<input type="radio" name="category" value="기타">기타
										</label>
									</td>
								</tr>
								<tr>
									<th>공개여부 <i class="star"></i></th>
									<td>
										<label class="radio">
											<input type="radio" name="ableview" value="공개"> 공개
										</label>
										<label class="radio">
											<input type="radio" name="ableview" value="비공개"> 비공개
										</label>
									</td>
								</tr>
								<tr>
									<th>제목<i class="star"></i></th>
									<td>
										<input type="text" name="title" placeholder="제목을 입력해주세요"
										title="제목을 입력해주세요" value="${board.title }">
									</td>
								</tr>
								<tr>
									<th class="th_top">내용<i class="star"></i></th>
									<td>
										<textarea name="content" placeholder="게시물 내용을 작성해 주세요"
										title="게시물 내용을 작성해 주세요" rows="10">${board.content }</textarea>
									</td>
								</tr>
							</table>
						</c:if>
						<div class="btn_wrap">
							<button type="submit" class="point_btn4">수정완료</button>
							<button type="button" class="point_btn5"
								onclick="location.href='/Cs_List.co';">취소</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</section>
</main>
<c:if test="${empty board}">
	<p>게시물 데이터를 찾을 수 없습니다.</p>
	<!-- board 값이 null인 경우 경고 -->
</c:if>
