<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main id="container" class="page"
style="padding: 200px;text-align: left;justify-content: center;
    align-items: center;position: relative;display: flex;">
	<section class="main_write">
		<div class="inner">
			<div class="head_wrap" style="padding-bottom: 35px;">
				<h2 class="main_tit" style="font-size: 25px;font-weight: 700;">크루 등록</h2>
				<p class="tit">크루 정보를 입력해주세요.</p>
			</div>
			<form action="/CrewRegistto.crew" method="post" name="RegisterFrm"
				onsubmit="return validateForm(this)">
				<div class="input_wrap">
					<div class="inner">
						<div class="view_head">
							<div class="wr1" style="padding-bottom:10px">
								<p style="padding-bottom:5px">크루명</p>
								<input type="text" name="name">
							</div>
							<div class="wr2" style="padding-bottom:10px">
								<p style="padding-bottom:5px">크루 소개</p>
								<input type="text" name="description">
							</div>
							<div class="wr3" style="padding-bottom:10px">
								<p class="location" style="padding-bottom:5px">활동지역</p>
								<div class="select_wrap" style="border: 1px solid;">
								<select id="lo" name="lo" size="1">
									<c:forEach var="location" items="${locations }"
										varStatus="status">
										<option value=${location.id}>${location.name}</option>
									</c:forEach>
								</select>
								</div>
							</div>
							<!-- <div class="wr4">
								<p class="clock" style="padding-bottom:10px">시간</p>
								<span class="btxt">오전 / 오후</span>
							</div>
							<div class="wr5">
								<p class="cal" style="padding-bottom:10px">정기런</p>
								<span class="ctxt">토요일</span>
							</div> -->
						</div>
						<div class="view_con" style="padding:20px;">게시물내용 및 이미지</div>
					</div>
				</div>
				<div class="btn_wrap2" style="display: flex;flex-direction: column;gap: 20px;">
					<a href="CrewListProcess.crew" style="text-align: center;border:none;
    				padding: 15px;border-radius: 15px;background: #8c5ba3;color: #fff;"> 목록</a>
					<button type="submit" style="text-align: center;padding: 15px;border-radius: 15px;
    				border: none;background: #8c5ba3;color: #fff;">작성 완료</button>
				</div>
			</form>
		</div>
	</section>
</main>
