<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Running</title>
	<link rel="icon" href="/resources/images/common/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="images/common/free-icon-running-7126743.png">
	
	<!-- css 파일 연결 -->
	
	<link href="/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  	<link href="/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  	<link href="/resources/css/aos.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  	<link href="/resources/css/list.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  	<link href="/resources/css/view.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  	<link href="/resources/css/crew_write.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
   	<link href="/resources/css/detail.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  	<link href="/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="/resources/css/CrewMain.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">

	<!-- js 파일 연결 -->
	<!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
	<script src="/resources/js/jquery-3.7.1.min.js"></script>
	<script src="/resources/js/jquery-ui.min.js"></script>
	<script src="/resources/js/swiper-bundle.min.js"></script>
	<script src="/resources/js/aos.js"></script>
	<script src="/resources/js/ui-common.js"></script>
  
</head>
<body>
	<jsp:include page="/JSP/Common/Header.jsp" />
	
	<jsp:include page="/JSP/Crew/${layout }.jsp" />
	
	<jsp:include page="/JSP/Common/Footer.jsp" />
</body>
</html>