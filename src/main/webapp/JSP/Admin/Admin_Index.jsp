<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String UserId = (String)session.getAttribute("UserId");
String admin="admin";
if(!UserId.equals(admin)){
	String path = "/";
	request.getRequestDispatcher(path).forward(request, response);
}
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>런닝크루</title>
	<link rel="icon" href="/resources/images/common/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="images/common/free-icon-running-7126743.png">
	
	<!-- css 파일 연결 -->
	<link href="/resources/css/jquery-ui.min.css" rel="stylesheet" type="text/css">
	<link href="/resources/css/swiper-bundle.min.css" rel="stylesheet" type="text/css">
<!--<link href="/resources/css/sub.css" rel="stylesheet" type="text/css">
	<link href="/resources/css/main.css" rel="stylesheet" type="text/css"> -->
	<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
	<link href="/resources/css/list.css" rel="stylesheet" type="text/css">
	<link href="/resources/css/admin_main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="/resources/css/admin_sub.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">

	<!-- js 파일 연결 -->
	<!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
	<script src="/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/resources/js/jquery-ui.min.js"></script>
	<script src="/resources/js/swiper-bundle.min.js"></script>
	<script src="/resources/js/aos.js"></script>
	<script src="/resources/js/ui-common.js"></script>
  	<script src="/resources/js/announcementNew.js"></script>
</head>
<body>
	<div id="skip_navi">
		<a href="#container">본문바로가기</a>
	</div>
	<div id="wrap">
		<header id="header" class="admin_header">
			<div class="inner">
				<div class="header_left">
					<div class="inner">
						<a href="/JSP/Admin/Admin_Index.jsp"> <img
							src='/resources/images/logo.png'
							alt="러닝메이트">
							<h2>running mate</h2> <span class="blind">러닝메이트 사이트 로고</span>
						</a>
					</div>
					</h1>
				</div>
				<div class="header_right">
					<div class=inner>
						<p>For a day when everyone runs happy</p>
						<a href="/">메인 페이지 이동</a>
					</div>
				</div>
			</div> 
		</header>
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
								<li><a href="/JSP/Admin/Member/Member_Index.jsp">회원관리</a></li>
								<li><a href="/JSP/Admin/Crew/Crew_Index.jsp">크루관리</a></li>
								<li><a href="#">setting(미구현)</a></li>
							</ul>
						</div>
					</aside> 
				</div>
				<%-- <jsp:include page="/JSP/Admin/${layout}.jsp" /> --%>
			</div>
		</main>
		<footer id="footer">
			<a href="#" class="top_btn">Top</a>
		</footer>
	</div>
</body>
</html>