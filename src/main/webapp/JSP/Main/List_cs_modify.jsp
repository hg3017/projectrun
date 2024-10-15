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
    <header id="header">
      <div class="inner">
          <h1 class="logo">
            <a href="Main.jsp">
              <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="러닝메이트">
              <span class="blind">러닝메이트</span>
            </a>
          </h1>
          <nav class="gnb_wrap">
            <ul class="gnb">
              <li>
                <a href="Crew_view.jsp">지역크루</a>
                <ul class="depth2">
                  <li><a href="/company/ceo"></a></li>
                  <li><a href="/company/philosophy"></a></li>
                  <li><a href="/company/business"></a></li>
                  <li><a href="/company/history"></a></li>
                  <li><a href="/product/list?type=9"></a></li>
                  <li><a href="/product/list?type=9"></a></li>
                  <li><a href="/product/list?type=5"></a></li>
                  <li><a href="/product/list?type=11"></a></li>
                  <li><a href="/product/list?type=7"></a></li>
                </ul>
              </li>
              <li>
                <a href="List_boardcrew.jsp">크루게시판</a>
                <ul class="depth2">
                  <li><a href="/esg/esg"></a></li>
                  <li><a href="/esg/eco"></a></li>
                  <li><a href="/esg/value"></a></li>
                  <li><a href="/esg/global"></a></li>
                  <li><a href="/esg/ethics"></a></li>
                  <li><a href="/esg/contribution"></a></li>
                  <li><a href="/esg/reports"></a></li>
                </ul>
              </li>
              <li>
                <a href="List_board.jsp">자유게시판</a>
                <ul class="depth2">
                  <li><a href="/esg/esg"></a></li>
                  <li><a href="/esg/eco"></a></li>
                  <li><a href="/esg/value"></a></li>
                  <li><a href="/esg/global"></a></li>
                  <li><a href="/esg/ethics"></a></li>
                  <li><a href="/esg/contribution"></a></li>
                  <li><a href="/esg/reports"></a></li>
                </ul>
              </li>
              <li>
                <a href="#">공지사항</a>
                <ul class="depth2">
                  <li><a href="/company/ceo"></a></li>
                  <li><a href="/company/philosophy"></a></li>
                  <li><a href="/company/business"></a></li>
                  <li><a href="/company/history"></a></li>
                </ul>
              </li>
              <li>
                <a href="List_cs.jsp">고객센터</a>
                <ul class="depth2">
                  <li><a href="/center/service"></a></li>
                  <li><a href="/center/supply?prod_cat_idx=1"></a></li>
                  <li><a href="/center/cyber"></a></li>
                  <li><a href="/center/safe"></a></li>
                  <li><a href="/support/privacy"></a></li>
                </ul>
              </li>
            </ul>
          </nav>
          <div class="btn_wrap">
            <a class="login_btn" href="../Login/Login.jsp">로그인</a>  
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
            <li>
              <a href="Crew_view.jsp">지역크루</a>
              <ul class="depth2">
                <li><a href="/products/sampleCheck.do"></a></li>
                <li><a href="/products/sampleCheck.do"></a></li>
                <li><a href="/products/sampleCheck.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="List_boardcrew.jsp">크루게시판</a>
              <ul class="depth2">
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="List_board.jsp">자유게시판</a>
              <ul class="depth2">
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="#">공지사항</a>
              <ul class="depth2">
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
                <li><a href="/about/greeting.do"></a></li>
              </ul>
            </li>
            <li>
              <a href="List_cs.jsp">고객센터</a>
              <ul class="depth2">
                <li><a href="investment/inquiry.do"></a></li>
                <li><a href="investment/inquiry.do"></a></li>
              </ul>
            </li>
          </ul>
        </div>
      </aside>
    </header>
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
          <div class="board_write">
            <form>
              <fieldset>
                <legend>게시물 수정하기</legend>
                <h3 class="tit">Q&A 게시물 수정하기</h3>
                <p class="note"><i class="star"></i>표시는 필수 입력 사항입니다.</p>
                <table>
                  <caption class="nohead">게시물 수정하기 테이블</caption>
                  <tr>
                    <th>제목<i class="star"></i></th>
                    <td><input type="text" placeholder="제목을 입력해주세요" title="제목을 입력해주세요"></td>
                  </tr>
                  <tr>
                    <th class="th_top">내용<i class="star"></i></th>
                    <td><textarea placeholder="게시물 내용을 작성해 주세요" title="게시물 내용을 작성해 주세요" rows="10"></textarea></td>
                  </tr>
                  <tr>
                    <th>첨부파일</th>
                    <td class="td_flex">
                      <div class="file_wrap">
                        <input type="text" readonly>
                        <label>
                          <input type="file" class="blind">
                          파일선택
                        </label>
                      </div>
                      <p class="file_note">※ 등록 가능 확장자 : pdf,docx,pptx,xlsx,jpg,jpeg,gif,png / 최대 5MB</p>
                    </td>
                  </tr>
                </table>
                <div class="btn_wrap">
                  <a class="point_btn4" href="List_cs.jsp">수정완료</a>
                  <a class="point_btn5" href="List_cs.jsp">취소</a>
                </div>
              </fieldset>
            </form>
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