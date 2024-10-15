<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <!-- <meta name="viewport" content="width=1004"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="러닝크루">
  <meta property="og:type" content="website">
  <meta  property="og:title" content="러닝">
  <meta property="og:url" content="https://dot386@dot386.dothome.co.kr/html/test/index.html">
  <meta property="og:image" content="/pub/images/og_image.jpg">
  <meta property="og:description" content="러닝크루">
  <title>러닝메이트</title>
  <link rel="icon" href="${pageContext.request.contextPath}/resources/images/common/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="images/common/free-icon-running-7126743.png">

	<!-- js 파일 연결 -->
  <!-- jquery 개발방식에선 js파일을 상단에 연결하여 빠르게 확인되게함 -->
  <script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/swiper-bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/ui-common.js?v=<?php echo time(); ?>"></script>

  <!-- css 파일 연결 -->
  <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/swiper-bundle.min.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/aos.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/list.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/view.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/crew_write.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
   <link href="${pageContext.request.contextPath}/resources/css/detail.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <!-- php타임스탬프 이용하여 css캐싱방지 -->
</head>
<body>
  <div id="wrap">

	<jsp:include page= '../Common/Header.jsp' />

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
          <div class="board_view">
            <div class="view_top">
              <a href="List_cs_modify.jsp" class="modify_btn">글 수정하기</a>
            </div>
            <div class="view_tit">
              <h3>모임 시간 외에 뒤풀이나 번개가 있나요?</h3>
              <span class="date">2024.09.30</span>
            </div>
            <div class="view_con">
              게시물 내용
            </div>
            <dl class="view_paging">
              <dt>이전글</dt>
              <dd><a href="#"></a></dd>
            </dl>
            <dl class="view_paging">
              <dt>다음글</dt>
              <dd><a href="#">러닝은 처음인데 참여해도 괜찮나요?</a></dd>
            </dl>
            <div class="btn_wrap">
              <a class="point_btn3" href="List_cs.jsp">목록</a>
            </div>
          </div>
        </div>
      </section>
    </main>
    <footer id="footer">
      <div class="inner">
        <div class="footer_top">
          <h2><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="러닝메이트"></h2>
          <div class="menu">
            <p><a href="#">개인정보처리방침</a></p>
            <p><a href="#">문의하기</a></p>
          </div>
        </div>
        <div class="footer_bottom">
          <h2>
            <span class="blind">러닝크루</span>
          </h2>
          <div class="txt_wrap">
            <p class="address">서울특별시 종로구 삼일대로17길 51<span></span>사업자번호 : 123-45-67890<span></span>대표자 : 김경문</p>
            <p class="copyright">COPYRIGHT © 2024 LX Glas Corp. All rights reserved.</p>
          </div>
        </div>
      </div>
    </footer>
  </div>
</body>
</html>