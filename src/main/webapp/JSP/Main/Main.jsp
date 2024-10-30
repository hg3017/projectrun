<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main id="container">
	<section class="main_visual">
		<h2 class="blind">메인슬라이더</h2>
	</section>
	<section class="main_crew">
		<div class="inner">
			<div class="head_wrap">
				<h2 class="main_tit">러닝크루</h2>
				<a class="crew_btn" href="/JSP/Main/Crew_write.jsp">크루등록하기</a>
			</div>
			<p class="tit">전국 각지에 흩어진 러닝크루들을 소개합니다.</p>
			<div class="swiper_wrap">
				<div class="swiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<a href="/JSP/Main/Crew_view.jsp">
								<div class="img_wrap">
									<img src="/resources/images/main_crew1.jpg" alt="">
								</div>
								<div class="txt_wrap">
									<h3>서울/경기</h3>
									<p>Sub3</p>
									<span>목요일<br>PM 7:30
									</span>
								</div>
							</a>
						</div>
						<div class="swiper-slide">
							<a href="/JSP/Main/Crew_view.jsp">
								<div class="img_wrap">
									<img src="/resources/images/main_crew2.jpg" alt="">
								</div>
								<div class="txt_wrap">
									<h3>서울/경기</h3>
									<p>Sub3</p>
									<span>목요일<br>PM 7:30
									</span>
								</div>
							</a>
						</div>
						<div class="swiper-slide">
							<a href="/JSP/Main/Crew_view.jsp">
								<div class="img_wrap">
									<img src="/resources/images/main_crew2.jpg" alt="">
								</div>
								<div class="txt_wrap">
									<h3>서울/경기</h3>
									<p>Sub3</p>
									<span>목요일<br>PM 7:30
									</span>
								</div>
							</a>
						</div>
						<div class="swiper-slide">
							<a href="/JSP/Main/Crew_view.jsp">
								<div class="img_wrap">
									<img src="/resources/images/main_crew2.jpg" alt="">
								</div>
								<div class="txt_wrap">
									<h3>서울/경기</h3>
									<p>Sub3</p>
									<span>목요일<br>PM 7:30
									</span>
								</div>
							</a>
						</div>
						<div class="swiper-slide">
							<a href="/JSP/Main/Crew_view.jsp">
								<div class="img_wrap">
									<img src="/resources/images/main_crew2.jpg" alt="">
								</div>
								<div class="txt_wrap">
									<h3>서울/경기</h3>
									<p>Sub3</p>
									<span>목요일<br>PM 7:30
									</span>
								</div>
							</a>
						</div>
						<div class="swiper-slide">
							<a href="/JSP/Main/Crew_view.jsp">
								<div class="img_wrap">
									<img src="/resources/images/main_crew1.jpg" alt="">
								</div>
								<div class="txt_wrap">
									<h3>서울/경기</h3>
									<p>Sub3</p>
									<span>목요일<br>PM 7:30
									</span>
								</div>
							</a>
						</div>
					</div>
					<div class="swiper-pagination"></div>
					<div class="swiper-button-prev arrow_btn"></div>
					<div class="swiper-button-next arrow_btn"></div>
				</div>
			</div>
		</div>
	</section>
	<section class="main_info">
		<div class="inner">
			<div class="board">
				<div class="board_list">
					<h2>Q&A</h2>
				</div>
				<table class="list">
					<c:forEach var="board" items="${board}" varStatus="status">
						<!-- 등록된 게시물이 있을 때 -->
						<tr class="board_tr" style="border-bottom: 1px solid #000;">
							<td style="gap: 20px; display: flex; padding: 12px;
								justify-content: space-between;	align-items: flex-end;
								text-align: end; font-size: 16px;">
								<a href="Cs_View.co?idx=${board.idx }">
									<p style=" display: -webkit-box; -webkit-box-orient: vertical; 
										-webkit-line-clamp: 1; overflow: hidden;">${board.title }</p>
								</a>
								<span class="date">${board.regidate }</span>
							</td> <!-- 제목 -->	<!-- 작성일자 -->
						</tr>
					</c:forEach>
					<tr>
					</tr>
					<!-- <li>
					<a href="/Cs_List.co">
					<p>모임 시간 외에 뒤풀이나 번개가 있나요?</p>
					<span class="date">2024.09.30</span>
					</a>
					</li>
					<li>
					<a href="/Cs_List.co">
					<p>러닝은 처음인데 참여해도 괜찮나요?</p>
					<span class="date">2024.09.30</span>
					</a>
					</li>
					<li>
					<a href="/Cs_List.co">
					<p>러닝은 처음인데 참여해도 괜찮나요?</p>
					<span class="date">2024.09.30</span>
					</a>
					</li> -->
				</table>
				<a href="/Cs_List.co" class="more_btn">더보기</a>
			</div>
		</div>
	</section>
</main>