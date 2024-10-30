<%@page import="java.util.List"%>
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
		<div class="board_list">
			<div class="inner">
				<form name="writeFrm" method="post" action="RegisterProcess.regi">
					<table border="1" width="80%">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" style="width: 90%;" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="text" name="pass" style="width: 90%;" /></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" style="width: 90%;" /></td>
						</tr>
						<tr>
							<td>등급</td>
							<td><input type="text" name="grade" style="width: 90%;" /></td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td><input type="text" name="nickname" style="width: 90%;" /></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" name="phone_number"
								style="width: 90%;" /></td>
						</tr>
						<!-- 					<tr>
						<td>LOCATION</td>
						<td><input type="text" name="location" style="width: 90%;" /></td>
					</tr> -->
						<tr>
							<td>지역</td>
							<td>
							<div class="select_wrap">
							<select id="lo" name="lo" size="1">
									<c:forEach var="location" items="${locations}"
										varStatus="status">
										<option value=${location.id}>${location.name}</option>
									</c:forEach>
							</select>
							</div>
							</td>
						</tr>
						<tr>
							<td>자기소개</td>
							<td><input type="text" name="description"
								style="width: 90%;" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="submit">작성 완료</button>
								<button type="reset">다시 입력</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</section>
</main>