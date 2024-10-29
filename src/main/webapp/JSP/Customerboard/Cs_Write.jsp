<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<form name="writeFrm" method="post" action="Cs_WriteProcess.co"
					onsubmit="return validateForm(this);">
					<fieldset>
						<legend>게시물 작성하기</legend>
						<h3 class="tit">Q&A 게시물 작성하기</h3>
						<p class="note">
							<i class="star"></i>표시는 필수 입력 사항입니다.
						</p>
						<table>
							<caption class="nohead">게시물 작성하기 테이블</caption>
							<tr>
								<th>분류 <i class="star"></i></th>
								<td><label class="radio"><input type="radio"
										name="category" value="cs" checked>모임개설하기</label> <label
									class="radio"><input type="radio" name="category"
										value="cv">모임참가하기</label> <label class="radio"><input
										type="radio" name="category" value="cl">기타</label></td>
							</tr>
							<tr>
								<th>공개여부 <i class="star"></i></th>
								<td><label class="radio"><input type="radio"
										name="ableview" value="공개" checked> 공개</label> <label
									class="radio"><input type="radio" name="ableview"
										value="비공개"> 비공개</label></td>
							</tr>
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
						</table>
						<div class="btn_wrap">
							<button type="submit" class="point_btn4">작성완료</button>
							<button type="button" class="point_btn5"
								onclick="location.href='/Cs_List.co';">취소</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</section>
</main>