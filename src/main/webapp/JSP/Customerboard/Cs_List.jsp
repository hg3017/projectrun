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
			<div class="m_wrap">
				<p>
					<a href="/">HOME</a><span></span>고객센터
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
											<option value="title" ${param.searchField eq 'title' ? 'selected' : ''}>제목</option>
											<option value="content" ${param.searchField eq 'content' ? 'selected' : ''}>내용</option>
										</select>
									</div>
									<div class="input_wrap">
										<input type="search" title="검색어를 입력해주세요"
											placeholder="검색어를 입력해주세요" name="searchWord" value="${param.searchWord }">
										<button type="submit" class="search_btn"></button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
<%-- 					<div class="btn_wrap">
						<c:if test="${UserId eq 'admin' }">
							<a href="/Cs_Write.co" class="write_btn">글쓰기</a>
							<!-- admin 전용 게시글 작성 -->
						</c:if>
					</div> --%>
				</div>
				<table>
					<tr>
						<th width="15%">NO</th>
						<th width="15%">분류</th>
						<th width="40%">제목</th>
						<th width="15%">조회수</th>
						<th width="15%">작성일자</th>
					</tr>
					<c:if test="${empty boards }">
						<tr>
							<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="board" items="${boards}" varStatus="status">
						<!-- 등록된 게시물이 있을 때 -->
						<tr>
							<td>${boards.size() - status.index}</td>	<!-- 테이블번호 -->
							<td>${board.category }</td>	<!-- 분류 -->
							<td><a href="Cs_View.co?idx=${board.idx }">${board.title }</a></td> <!-- 제목 -->
							<td>${board.visitcount }</td>	<!-- 조회수 -->
							<td>${board.regidate }</td>	<!-- 작성일자 -->
						</tr>
					</c:forEach>
				</table>
				<div class="board_pagination">${pagingStr}</div>
				<!-- 페이징 링크 표시 -->
			</div>
		</div>
	</section>
	<section class="ban_box">
		<div class="inner">
			<div class="etc">
				<ul class="etc">
					<c:if test="${not empty UserId}">
					<li><a href="/Cs_Write.co" class="etc_left"><p>1:1 상담하기</p></a></li>
					</c:if>
					<li>
						<a class="etc_right">
							<p>전화 문의하기<span></span>TEL : 02-1234-5678</p>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</section>
</main>