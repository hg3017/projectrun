<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div class="m_wrap">
				<p>
					<a href="JSP/Main/Main.jsp">HOME</a><span></span>자유게시판
				</p>
			</div>
			<div class="board_list">
				<div class="list_wrap">
					<div class="board_search_wrap">
						<form method="get">
							<fieldset>
								<legend>게시물 검색</legend>
								<div class="board_search">
									<div class="select_wrap">
										<select name="searchField">
											<option value="title">제목</option>
											<option value="content">내용</option>
										</select>
									</div>
									<div class="input_wrap">
										<input type="search" placeholder="검색어를 입력해주세요"
											name="searchWord" />
										<button type="submit" class="search_btn"></button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="btn_wrap">
						<c:if test="${not empty UserId}">
							<a href="#" class="write_btn"
								onclick="location.href='/Fb_Write.free';">글쓰기</a>
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
									<!--제목(+ 하이퍼링크)--> <a href="Fb_View.free?idx=${board.idx }">${board.title }</a>
								</td>
								<td>${board.member_id }</td>
								<!--작성자 아이디-->
								<td>${board.visitcount }</td>
								<!--조회수-->
								<td>${board.regidate }</td>
								<!--작성일-->
							</tr>
						</c:forEach>
					</table>
					<div class="board_pagination">
						${pagingStr}
						<!-- 페이징 링크 표시 -->
					</div>
				</div>
			</div>
		</div>
	</section>
</main>