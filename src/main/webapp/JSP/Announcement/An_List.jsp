<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div class="m_wrap">
				<p>
					<a href="JSP/Main/Main.jsp">HOME</a><span></span>공지사항
				</p>
			</div>
			<div class="board_list">
				<div class="list_wrap"></div>
			</div>
		</div>
	</section>
</main>
<div class="board_list">
	<form method="get" class="list_wrap">
		<table class="board_search_wrap">
			<tr>
				<td align="right">
					<div class="board_search">
						<div class="select_wrap">
							<select name="searchField">
								<option value="title">제목</option>
								<option value="content">내용</option>
							</select>
						</div>
						<div class="input_wrap">
							<input type="search" placeholder="검색어를 입력해주세요" name="searchWord" />
							<button type="submit" class="search_btn"></button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<div class="btn_wrap">
		<c:if test="${UserId eq 'hong01' }">
			<button type="button" class="write_btn"
				onclick="location.href='An_Write.an';">글쓰기</button>
		</c:if>
	</div>

	<!-- 공지사항 목록 -->
	<table>
		<!-- 각각의 이름 -->
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:if test="${empty boards}">
			<tr>
				<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
			</tr>
		</c:if>

		<c:forEach var="board" items="${boards }" varStatus="status">
			<tr align="center">
				<td>${boards.size() - status.index}</td>
				<!--게시물 번호-->
				<td>
					<!--제목(+ 하이퍼링크)--> <a href="An_View.an?num=${board.num }">${board.title }</a>
				</td>
				<td>${board.id }</td>
				<!--작성자 아이디-->
				<td>${board.visitcount }</td>
				<!--조회수-->
				<td>${board.postdate }</td>
				<!--작성일-->
			</tr>
		</c:forEach>
	</table>
	<div class="board_pagination">
		${pagingStr}
		<!-- 페이징 링크 표시 -->
	</div>
</div>

