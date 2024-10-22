<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="UploadProcess.jsp" method="post"
	enctype="multipart/form-data">
	<table>
		<caption class="nohead">자유게시판 작성하기 테이블</caption>
		<tr>
			<th>작성자 <i class="star"></i></th>
			<td><input type="text" name="member_id" value="${UserId }" readonly></td>
		</tr>
		<tr>
			<th>제목 <i class="star"></i></th>
			<td><input type="text" name="title" placeholder="제목을 입력해주세요"
				title="제목을 입력해주세요"></td>
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
						type="file" name="attachedFile" class="blind">파일선택
					</label>
				</div>
				<p class="file_note">※ 등록 가능 확장자 :
					pdf,docx,pptx,xlsx,jpg,jpeg,gif,png / 최대 5MB</p>
			</td>
		</tr>
		<!-- 		<tr>
			<td colspan="2"><input type="submit" value="업로드"></td>
		</tr> -->
	</table>
	<div class="btn_wrap">
		<button type="submit" class="point_btn4">작성완료</button>
		<button type="button" class="point_btn5"
			onclick="location.href='/Fb_List.free';">취소</button>
	</div>
</form>