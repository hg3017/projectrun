<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="UploadProcess.jsp" method="post"
	enctype="multipart/form-data">
	<tr>
		<th>첨부파일</th>
		<td class="td_flex">
			<div class="file_wrap">
				<input type="text" readonly> <label> <input
					type="file" name="attachedFile" class="blind">
				</label>
			</div>
			<p class="file_note">※ 등록 가능 확장자 :
				pdf,docx,pptx,xlsx,jpg,jpeg,gif,png / 최대 5MB</p>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="업로드"></td>
	</tr>
</form>