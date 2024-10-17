<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <!-- <meta name="viewport" content="width=1004"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="러닝크루">
  <meta property="og:type" content="website">
  <meta  property="og:title" content="러닝">
  <meta property="og:url" content="https://dot386@dot386.dothome.co.kr/html/test/index.html">
  <meta property="og:image" content="/pub/images/og_image.jpg"> <!-- 뭔지 확인이 필요합니다.  -->
  <meta property="og:description" content="러닝크루">
  <title>러닝메이트</title>
  <link rel="icon" href="/resources/images/common/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/resources/images/common/free-icon-running-7126743.png">

	<!-- js 파일 연결 -->
  <!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
  <script src="/resources/js/jquery-3.7.1.min.js"></script>
  <script src="/resources/js/jquery-ui.min.js"></script>
  <script src="/resources/js/swiper-bundle.min.js"></script>
  <script src="/resources/js/aos.js"></script>
  <script src="/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

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
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
</head>
<body>
   <div id="wrap">
    <jsp:include page='/JSP/Common/Header.jsp' />
    <main id="container" class="crew_page">
    <section class="main_report">
      <div class="inner">
        <div class="head_wrap">
          <h2 class="main_tit">러닝크루</h2>
          <a class="crew_btn" href="/JSP/Main/Crew_write.jsp">크루등록하기</a>
        </div>
        <p class="tit">전국 각지에 흩어진 러닝크루들을 소개합니다.</p>
        <div class="filter_container">
          <ul class="social_tab">
            <li class="active">
              <a href="#" data-filter="all">전체</a>
            </li>
            <li >
              <a href="#" data-filter=".capital">수도권</a>
            </li>
            <li>
              <a href="#" data-filter=".Chungcheong">충청권</a>
            </li>
            <li>
              <a href="#" data-filter=".Gangwon">강원권</a>
            </li>
            <li>
              <a href="#" data-filter=".Jeolla">전라권</a>
            </li>
            <li>
              <a href="#" data-filter=".Gyeongsang">경상권</a>
            </li>
          </ul>
          <div class="report_wrap">
            <ul class="all_view">
              <c:forEach var="crewList" items="${CrewLists }" varStatus="status">
	              <li class="featured_card">
	                <a href="/CrewMainProcess.crew?crewName=${crewList.name }">
	                <!-- <a href="/CrewMainProcess.crew"> -->
	                  <div class="img_wrap">
	                    <img src="/resources/images/main_crew1.jpg" alt="">
	                  </div>
	                  	<div class="txt_wrap">
	                  	
		                  <h3> ${crewList.name }</h3>
		                  <p>  ${crewList.location_id }</p>
		                  <span> ${crewList.regidate }</span>
	                	</div>
	                </a>
	              </li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </section>
    </main>
    <jsp:include page= '/JSP/Common/Footer.jsp' />
  </div>
</body>
</html>