<%@page import="java.util.List"%>
<%@page import="DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 결과 확인(웹 페이지에 출력)
List<MemberDTO> members = (List<MemberDTO>)request.getAttribute("members");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=1004"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="러닝크루">
<meta property="og:type" content="website">
<meta property="og:title" content="러닝">
<meta property="og:url"
	content="https://dot386@dot386.dothome.co.kr/html/test/index.html">
<meta property="og:image" content="/pub/images/og_image.jpg">
<meta property="og:description" content="러닝크루">
<title>러닝메이트</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/common/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="images/common/free-icon-running-7126743.png">

<!-- js 파일 연결 -->
<!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
<script src="/resources/js/jquery-3.7.1.min.js"></script>
<script src="/resources/js/jquery-ui.min.js"></script>
<script src="/resources/js/swiper-bundle.min.js"></script>
<script src="/resources/js/aos.js"></script>
<script src="/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

<!-- css 파일 연결 -->
<link href="/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link
	href="/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/admin_main.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/admin_sub.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<link href="/resources/css/common.css?v=<?php echo time(); ?>"
	rel="stylesheet" type="text/css">
<!-- php타임스탬프 이용하여 css캐싱방지 -->
</head>

<body>
	<div id="skip_navi">
		<a href="#container">본문바로가기</a>
	</div>
	<div id="wrap">
		<header id="header">
			<div class="inner">
				<div class="header_left">
					<div class="inner">
						<a href="/JSP/Admin/Admin_Index.jsp"> <img src='/resources/images/logo.png'
							alt="러닝메이트">
							<h2>running mate</h2> <span class="blind">러닝메이트 사이트 로고</span>
						</a>
					</div>
				</div>
				<div class="header_right">
					<div class=inner>
						<p>For a day when everyone runs happy</p>
					</div>
				</div>
			</div>
		</header>
		<div id="container_wrapper">
			<main id="container">
				<div class="inner">
					<div class="side_menu">
						<aside class="menu_wrap">
							<div class="menu_inner">
								<h2>
									<span class="blind">administer</span>
								</h2>
								<ul class="menu">
								<li><a href="#">dashboard(미구현)</a></li>
								<li><a href="/JSP/Admin/Member/Member_Index.adme">member</a></li>
								<li><a href="/JSP/Admin/Crew/Crew_Index.adcr">crew</a></li>
								<li><a href="#">setting(미구현)<a></li>
								</ul>
							</div>
						</aside>
					</div>
					<div class="contents">
						<div class="inner">
							<div class="board_search_wrap_admin">
								<form>
									<fieldset>
										<legend>게시물 검색</legend>
										<div class="board_search_admin">
											<select>
												<option>아이디</option>
												<option>닉네임</option>
												<option>지역</option>
											</select>
										</div>
										<div class="input_wrap_admin">
											<input type="search" placeholder="검색어를 입력해주세요"
												title="검색어를 입력해주세요">
											<button type="submit" class="search_btn">
												<span class="blind">게시물 검색</span>
											</button>
										</div>
									</fieldset>
								</form>
							</div>
							<div class="board_list_admin">
								<table border="1" width="80%">
									<tr>
										<th width="11%">ID</th>
										<th width="11%">PASS</th>
										<th width="11%">NAME</th>
										<th width="11%">GRADE</th>
										<th width="11%">NICKNAME</th>
										<th width="11%">LOCATION</th>
										<th width="12%">PHONE_NUMBER</th>
										<th width="11%">REGIDATE</th>
										<th width="11%">EDITDATE</th>
									</tr>
									<%for(MemberDTO member: members) {%>
									<tr align="center">
										<td><a href="Member_View.adme?id=<%=member.getId()%>"><%=member.getId() %></a></td>
										<td><%=member.getPass() %></td>
										<td><%=member.getName() %></td>
										<td><%=member.getGrade() %></td>
										<td><%=member.getNickname() %></td>
										<td><%=member.getLocation() %></td>
										<td><%=member.getPhone_number() %></td>
										<td><%=member.getRegidate() %></td>
										<td><%=member.getEditdate() %></td>
										<%} %>
									
									<tr>
										<td colspan="4"><a href="/JSP/Admin/Member/Member_Write.adme">[회원 가입]</a></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<footer id="footer">
			<a href="#" class="top_btn">Top</a>
		</footer>
	</div>
</body>
</html>