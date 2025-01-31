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
					<a href="/">HOME</a><span></span>공지사항
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
										<select  name="searchField"> <!-- select 요소를 통해 검색 필드를 선택 / searchField 파라미터가 설정됨 -->
											<option value="title" ${param.searchField eq 'title' ? 'selected' : ''}>제목</option>
											<option value="content" ${param.searchField eq 'content' ? 'selected' : ''}>내용</option>
										</select>
									</div>
									<div class="input_wrap">
										<input type="search" placeholder="검색어를 입력해주세요"
											name="searchWord" value="${param.searchWord }" />
										<button type="submit" class="search_btn"></button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="btn_wrap">
						<c:if test="${UserId eq 'admin' }"> <!-- 해당 값이 같은지 -->
							<a href="#" class="write_btn"
								onclick="location.href='/An_Write.an';">글쓰기</a>
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
						<!-- boards 리스트의 각 게시물을 반복하며 테이블 행으로 출력 -->
						<c:forEach var="board" items="${boards }" varStatus="status">
							<tr align="center">
								<td>${board.no }</td>
								<!--게시물 번호-->
								<td>
								<!--제목(+ 하이퍼링크)--> 
								<a href="An_View.an?idx=${board.idx }">${board.title }</a>
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
						${pagingStr}  <!-- 서블릿,컨트롤러에서 생성된 페이밍HTML 포함 -->
						<!-- 페이징 링크 표시 -->
					</div>
				</div>
			</div>
		</div>
	</section>
</main>

