<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
  <link href="${pageContext.request.contextPath}/resources/css/sub.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/main.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/css/common.css?v=<?php echo time(); ?>" rel="stylesheet" type="text/css">
  
<header id="header">
  <div class="inner">
    <h1 class="logo">
      <a href="/JSP/Main/Main.jsp">
        <img src="/resources/images/logo.png" alt="러닝메이트">
        <span class="blind">러닝메이트</span>
      </a>
    </h1>
    <nav class="gnb_wrap">
      <ul class="gnb">
        <li><a href="/JSP/Main/Crew_view.jsp">지역크루</a></li>
        <li>
          <a href="#">게시판</a>
          <ul class="depth2">
            <li><a href="/JSP/Main/List_boardcrew.jsp">크루게시판</a></li>
            <li><a href="/JSP/Main/List_board.jsp">자유게시판</a></li>
          </ul>
        </li>
        <li><a href="/An_List.an">공지사항</a></li>
        <li><a href="/JSP/Main/List_cs.jsp">고객센터</a></li>
      </ul>
    </nav>
    <div class="btn_wrap">
        <a class="login_btn" href="/JSP/Login/Login.jsp">로그인</a>  
        <button type="button" class="sitemap_btn">
          <span class="blind">사이트맵 열기</span>
          <i></i>
          <i></i>
          <i></i>
        </button>
    </div>
  </div>
  <aside class="menu_wrap">
    <div class="menu_inner">
      <h2><span class="blind">러닝크루</span></h2>
      <ul class="menu">
        <li><a href="/JSP/Main/Crew_view.jsp">지역크루</a></li>
          <li>
            <a href="#">게시판</a>
            <ul class="depth2">
              <li><a href="/JSP/Main/List_boardcrew.jsp">크루게시판</a></li>
              <li><a href="/JSP/Main/List_board.jsp">자유게시판</a></li>
            </ul>
          </li>
          <li><a href="/An_List.an">공지사항</a></li>
          <li><a href="/JSP/Main/List_cs.jsp"">고객센터</a></li>
      </ul>
    </div>
  </aside>
</header>