<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="contents">
	<div class="inner">
		<div class="board_contents">
		<div class="board_search_wrap" style="background:none;">
							<form style="padding-left: 130px;">
								<fieldset style="display: flex;gap:10px;">
									<legend>게시물 검색</legend>
									<div class="board_search">
									<div class="select_wrap" style="width: 150px;text-align: center;">
										<select>
											<option>아이디</option>
											<option>닉네임</option>
											<option>지역</option>
										</select>
									</div>
									<div class="input_wrap">
										<input type="search" placeholder="검색어를 입력해주세요"
											title="검색어를 입력해주세요">
										<button type="submit" class="search_btn">
										</button>
									</div>
									</div>
								</fieldset>
							</form>
						</div>
		<div class="board_list_admin">
			<table border="1" width="80%">
				<tr class="ad_list" style="background: #8c5ba3; height: 50px; color: #fff;">
					<th width="11%">NO</th>
					<th width="11%">ID</th>
					<th width="11%">PASS</th>
					<th width="11%">NAME</th>
					<th width="11%">GRADE</th>
					<th width="16%">NICKNAME</th>
					<th width="11%">LOCATION</th>
					<th width="16%">PHONE_NUMBER</th>
					<th width="11%">REGIDATE</th>
					<th width="11%">EDITDATE</th>
				</tr>
				<c:if test="${empty members}">
					<tr>
						<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="member" items="${members }" varStatus="status">
					<tr align="center">
						<td>${members.size() - status.index}</td>
						<!--게시물 번호-->
						<td>
							<!--제목(+ 하이퍼링크)--> <a href="Member_View.adme?id=${member.id}">${member.id}</a>
						</td>
						<td>${member.pass}</td>
						<td>${member.name}</td>						
						<td>${member.grade}</td>
						<td>${member.nickname}</td>
						<td>${member.location}</td>
						<td>${member.phone_number}</td>
						<td>${member.regidate}</td>
						<td>${member.editdate}</td>
					</tr>
				</c:forEach>

				<tr style="height: 50px;font-size:18px;font-weight: bold;"align="center">
					<td colspan="10"><a href="/Member_Write.adme">회원가입</a></td>
				</tr>
			</table>
			<div class="board_pagination">
				${pagingStr}
				<!-- 페이징 링크 표시 -->
			</div>
		</div>
	</div>
	</div>
</div>