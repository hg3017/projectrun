<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/JSP/Announcement/IsLoggedIn.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div class="board_write">
				<form name="writeFrm" method="post" action="An_WriteProcess.an" enctype="multipart/form-data" onsubmit="return validateForm(this);">
					<fieldset>
						<legend>공지사항 작성하기</legend>
						<h3 class="tit">공지사항 작성하기</h3>
						<p class="note">
							<i class="star"></i>표시는 필수 입력 사항입니다.
						</p>
						<table>
							<caption class="nohead">공지사항 작성하기 테이블</caption>
							<tr>
								<th>작성자 <i class="star"></i></th>
								<td><input type="text" name="member_id" value="${UserId }"
									readonly></td>
							</tr>
							<tr>
								<th>제목 <i class="star"></i></th>
								<td>
									<input type="text" name="title" placeholder="제목을 입력해주세요" title="제목을 입력해주세요"></td>
							</tr>
							<tr>
								<th class="th_top">내용 <i class="star"></i></th>
								<td>
									<textarea name="content" placeholder="게시물 내용을 작성해 주세요" title="게시물 내용을 작성해 주세요" rows="10"></textarea>
								</td>
							</tr>
 							<tr>
								<th>첨부파일</th>
								<td class="td_flex">
									<div class="file_wrap">
										<input type="text" placeholder="첨부파일 없음" readonly > 
										<label>
											<input type="file" name="file" >
										</label>
									</div>
									<p class="file_note">
										※ 등록 가능 확장자 : pdf,docx,pptx,xlsx,jpg,jpeg,gif,png / 최대 5MB <br>
									</p>
								</td>
							</tr>
						</table>
						<div class="btn_wrap">
							<button type="submit" class="point_btn4">작성완료</button>
							<button type="button" class="point_btn5" onclick="location.href='/An_List.an';">취소</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</section>
</main>
