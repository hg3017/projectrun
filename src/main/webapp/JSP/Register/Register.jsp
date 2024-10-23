<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main id="container" class="sub_container list_page">
	<section class="sub_visual">
		<div class="inner">
			<div class="sub_wrap">
				<h3>회원가입</h3>
			</div>
		</div>
	</section>
	<section class="contents">
		<div class="inner">
			<form name="writeFrm" method="post" action="Member_WriteProcess.adme">
				<table border="1" width="80%">
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>PASS</td>
						<td><input type="text" name="pass" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>NAME</td>
						<td><input type="text" name="name" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>GRADE</td>
						<td><input type="text" name="grade" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>NICKNAME</td>
						<td><input type="text" name="nickname" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>PHONE_NUMBER</td>
						<td><input type="text" name="phone_number"
							style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>LOCATION</td>
						<td><input type="text" name="location" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td>DESCRIPTION</td>
						<td><input type="text" name="description" style="width: 90%;" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit">작성 완료</button>
							<button type="reset">다시 입력</button>
							<button type="button"
								onclick="location.href='/JSP/Admin_Sample/List.jsp'">목록
								보기</button>
							<button type="button" onclick="location.href='List.jsp'">목록
								보기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
</main>